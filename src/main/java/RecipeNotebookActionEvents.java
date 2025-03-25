import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class RecipeNotebookActionEvents implements IRecipeNotebookActions {

    private final static DefaultListModel<String> listModelIngredients = new DefaultListModel<>();
    private final static DefaultListModel<String> listModelTags = new DefaultListModel<>();
    public final static RecipeNotebookGUI GUI = new RecipeNotebookGUI();

    public void bindListModelsAndActions(){

        //TODO: Better way to bind these
        //ListModels
        GUI.getLstIngredients().setModel(listModelIngredients);
        GUI.getLstTags().setModel(listModelTags);
        //ActionListeners
        //Add New Recipe
        GUI.getTxtAddIngredients().addActionListener(this::txtIngredientsEntered);
        GUI.getTxtAddTags().addActionListener(this::txtTagsEntered);
        GUI.getBtnAddRecipe().addActionListener(this::addRecipeButtonClicked);

        //Search Recipes
        GUI.getRbName().addActionListener(this::rbNameSelected);
        GUI.getRbIngredients().addActionListener(this::rbIngredientsSelected);
        GUI.getRbInstructions().addActionListener(this::rbInstructionSelected);
        GUI.getRbTags().addActionListener(this::rbTagsSelected);
        GUI.getBtnFind().addActionListener(this::findButtonClicked);

    }

    public void addRecipeButtonClicked(ActionEvent e) {
        final Recipe recipe = new Recipe();
        recipe.setName(GUI.getTxtAddRecipeName().getText().trim()); //TODO:Better input sanitization
        recipe.setInstructions(GUI.getTxtarAddInstructions().getText().trim());
        recipe.setTagsList(new ArrayList<>()); //TODO: Initializing this way?
        recipe.setIngredientList(new ArrayList<>()); //TODO: Initializing this way?

        //Add Strings in the list to the model
        for (Object o : listModelTags.toArray()){
            recipe.getTagsList().add((String)o);
        }

        for (Object o : listModelIngredients.toArray()){
            recipe.getIngredientList().add((String)o);
        }

        MongoDelegator.doInsert(recipe);
    }

    public void findButtonClicked(ActionEvent e){
        if (GUI.getRbName().isSelected()){
            MongoDelegator.getByName(GUI.getTxtSearchName().getText().trim());
        }
        else if (GUI.getRbInstructions().isSelected()){
            MongoDelegator.getByInstructions(GUI.getTxtarSearchInstructions().getText().trim());
        }
        else if (GUI.getRbIngredients().isSelected()){
            //do search
        }
        else if (GUI.getRbTags().isSelected()){
            MongoDelegator.getByTags(List.of(GUI.getTxtSearchTags().getText().split(", ")));//TODO: Adjust split value to account for whitespace or not
        }
    }

    public void rbNameSelected(ActionEvent e) {
        CardLayout layout = (CardLayout) GUI.getPnlSearchInput().getLayout();
        layout.show(GUI.getPnlSearchInput(), "nameSearchCard");
    }

    public void rbInstructionSelected(ActionEvent e) {
        CardLayout layout = (CardLayout) GUI.getPnlSearchInput().getLayout();
        layout.show(GUI.getPnlSearchInput(), "descriptionSearchCard");
    }

    public void rbIngredientsSelected(ActionEvent e) {
        CardLayout layout = (CardLayout) GUI.getPnlSearchInput().getLayout();
        layout.show(GUI.getPnlSearchInput(), "ingredientSearchCard");
    }

    public void rbTagsSelected(ActionEvent e) {
        CardLayout layout = (CardLayout) GUI.getPnlSearchInput().getLayout();
        layout.show(GUI.getPnlSearchInput(), "tagsSearchCard");
    }

    //Naming these methods "Entered" since that's when the event fires
    public void txtIngredientsEntered(ActionEvent e) {
        listModelIngredients.addElement(GUI.getTxtAddIngredients().getText().trim());
        GUI.getTxtAddIngredients().setText("");
    }

    public void txtTagsEntered(ActionEvent e) {
        listModelTags.addElement(GUI.getTxtAddTags().getText().trim());
        GUI.getTxtAddTags().setText("");
    }
}

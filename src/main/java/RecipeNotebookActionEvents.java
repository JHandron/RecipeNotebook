import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

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
        GUI.getTxtIngredients().addActionListener(this::txtIngredientsEntered);
        GUI.getTxtTags().addActionListener(this::txtTagsEntered);
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
        recipe.setName(GUI.getTxtRecipeName().getText().trim()); //TODO:Better input sanitization
        recipe.setInstructions(GUI.getTxtaInstructions().getText().trim());
        recipe.setTagsList(new ArrayList<>()); //TODO:??
        recipe.setIngredientList(new ArrayList<>()); //TODO:??

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
        MongoDelegator.getByName(GUI.getTxtNameSearch().getText().trim());
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
        listModelIngredients.addElement(GUI.getTxtIngredients().getText().trim());
        GUI.getTxtIngredients().setText("");
    }

    public void txtTagsEntered(ActionEvent e) {
        listModelTags.addElement(GUI.getTxtTags().getText().trim());
        GUI.getTxtTags().setText("");
    }
}

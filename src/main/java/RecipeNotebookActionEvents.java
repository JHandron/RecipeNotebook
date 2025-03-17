import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class RecipeNotebookActionEvents {

    private final static DefaultListModel<String> listModelIngredients = new DefaultListModel<>();
    private final static DefaultListModel<String> listModelTags = new DefaultListModel<>();
    public final static RecipeNotebookGUI GUI = new RecipeNotebookGUI();

    public void bindListModelsAndActions(){
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

    }

    private void addRecipeButtonClicked(ActionEvent e) {
        final Recipe recipe = new Recipe();
        recipe.setName(GUI.getTxtRecipeName().getText().trim());
        recipe.setInstructions(GUI.getTxtaInstructions().getText().trim());
        //Make this insert the tags from the list model
        //TODO: translate listModel into RecipeModel
        MongoDelegator.doInsert(recipe);
    }

    private void rbNameSelected(ActionEvent e) {
        CardLayout layout = (CardLayout) GUI.getPnlSearchInput().getLayout();
        layout.show(GUI.getPnlSearchInput(), "nameSearchCard");
    }

    private void rbInstructionSelected(ActionEvent e) {
        CardLayout layout = (CardLayout) GUI.getPnlSearchInput().getLayout();
        layout.show(GUI.getPnlSearchInput(), "descriptionSearchCard");
    }

    private void rbIngredientsSelected(ActionEvent e) {
        CardLayout layout = (CardLayout) GUI.getPnlSearchInput().getLayout();
        layout.show(GUI.getPnlSearchInput(), "ingredientSearchCard");
    }

    private void rbTagsSelected(ActionEvent e) {
        CardLayout layout = (CardLayout) GUI.getPnlSearchInput().getLayout();
        layout.show(GUI.getPnlSearchInput(), "tagsSearchCard");
    }

    //Naming these methods "Entered" since that's when the event fires
    private void txtIngredientsEntered(ActionEvent e) {
        listModelIngredients.addElement(GUI.getTxtIngredients().getText().trim());
        GUI.getTxtIngredients().setText("");
    }

    private void txtTagsEntered(ActionEvent e) {
        listModelTags.addElement(GUI.getTxtTags().getText().trim());
        GUI.getTxtTags().setText("");
    }
}

package org.jhandron;

public class PnlAddNewController {

    private final PnlAddNew view;
    private final PnlRecipeDataController recipeDataController;

    public PnlAddNewController(PnlAddNew view) {
        this.view = view;
        this.recipeDataController = view.getRecipeDataPanel().getController();
    }

    public void handleAddNewRecipe(String recipeName, String instructions) {
        Recipe recipe = recipeDataController.toRecipe(recipeName, instructions);
        MongoDelegator.doInsert(recipe);
        resetForm();
    }

    private void resetForm() {
        view.setRecipeNameText("");
        view.setInstructionsText("");
        recipeDataController.clearRecipeData();
    }
}

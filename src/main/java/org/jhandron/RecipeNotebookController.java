package org.jhandron;

import javax.swing.DefaultListModel;
import java.util.Arrays;
import java.util.List;

public class RecipeNotebookController implements RecipeSelectionListener {

    private final RecipeNotebookView view;
    private final DefaultListModel<String> lstMdlIngredients = new DefaultListModel<>();
    private final DefaultListModel<String> lstMdlTags = new DefaultListModel<>();
    private final RecipeTableModel tblMdlRelatedRecipes = new RecipeTableModel();

    public RecipeNotebookController(RecipeNotebookView view) {
        this.view = view;
    }

    public void initializeViewBindings() {
        view.bindIngredientListModel(lstMdlIngredients);
        view.bindTagListModel(lstMdlTags);
        view.bindRelatedRecipesTableModel(tblMdlRelatedRecipes);
    }

    public void handleIngredientsAdded(String p_input) {
        addTokensToModel(p_input, lstMdlIngredients);
    }

    public void handleIngredientsDeleted(String p_input) {

    }

    public void handleTagsAdded(String p_input) {
        addTokensToModel(p_input, lstMdlTags);
    }

    public void handleTagsDeleted(String p_input) {

    }

    public void handleAddNewRecipe(String p_recipeName, String p_instructions) {
        final Recipe recipe = new Recipe();
        recipe.setName(p_recipeName.trim());
        recipe.setInstructions(p_instructions.trim());

        for (final Object ingredient : lstMdlIngredients.toArray()) {
            recipe.getIngredients().add((String) ingredient);
        }
        for (final Object tag : lstMdlTags.toArray()) {
            recipe.getTags().add((String) tag);
        }
        for (final Recipe relatedRecipe : tblMdlRelatedRecipes.getRecipes()) {
            recipe.getRelatedRecipeIds().add(relatedRecipe.getId());
        }
        MongoDelegator.doInsert(recipe);
    }

    public void handleSearchRequested() {
        view.openSearchDialog(this);
    }

    public void handleExitRequested() {
        view.exitApplication();
    }

    @Override
    public void onRecipesSelected(List<Recipe> p_recipes) {
        updateRelatedRecipesTable(p_recipes);
    }

    private void addTokensToModel(String rawInput, DefaultListModel<String> model) {
        if (rawInput == null || rawInput.isBlank()) {
            return;
        }
        Arrays.stream(rawInput.split(","))
            .map(String::trim)
            .filter(token -> !token.isEmpty())
            .forEach(model::addElement);
    }

    private void updateRelatedRecipesTable(List<Recipe> p_recipes) {
        tblMdlRelatedRecipes.clearModel();
        for (Recipe recipe : p_recipes) {
            tblMdlRelatedRecipes.addRecipe(recipe);
        }
    }
}

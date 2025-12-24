package org.jhandron;

import javax.swing.DefaultListModel;
import java.util.Arrays;
import java.util.List;

public class RecipeNotebookController implements RecipeSelectionListener {

    private final RecipeNotebookView view;
    private final DefaultListModel<String> ingredientModel = new DefaultListModel<>();
    private final DefaultListModel<String> tagModel = new DefaultListModel<>();
    private final RecipeTableModel relatedRecipesModel = new RecipeTableModel();

    public RecipeNotebookController(RecipeNotebookView view) {
        this.view = view;
    }

    public void initializeViewBindings() {
        view.bindIngredientListModel(ingredientModel);
        view.bindTagListModel(tagModel);
        view.bindRelatedRecipesTableModel(relatedRecipesModel);
    }

    public void handleIngredientsEntered(String rawInput) {
        addTokensToModel(rawInput, ingredientModel);
    }

    public void handleTagsEntered(String rawInput) {
        addTokensToModel(rawInput, tagModel);
    }

    public boolean shouldAddNewRecipeButtonEnable(String recipeName, String instructions) {
        return !recipeName.trim().isEmpty()
            && !ingredientModel.isEmpty()
            && !tagModel.isEmpty()
            && !instructions.trim().isEmpty();
    }

    public void handleAddRecipe(String recipeName, String instructions) {
        final Recipe recipe = new Recipe();
        recipe.setName(recipeName.trim());
        recipe.setInstructions(instructions.trim());

        for (final Object ingredient : ingredientModel.toArray()) {
            recipe.getIngredients().add((String) ingredient);
        }
        for (final Object tag : tagModel.toArray()) {
            recipe.getTags().add((String) tag);
        }
        for (final Recipe relatedRecipe : relatedRecipesModel.getRecipes()) {
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
    public void onRecipesSelected(List<Recipe> recipes) {
        updateRelatedRecipesTable(recipes);
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

    private void updateRelatedRecipesTable(List<Recipe> recipes) {
        relatedRecipesModel.clearModel();
        for (Recipe recipe : recipes) {
            relatedRecipesModel.addRecipe(recipe);
        }
    }
}

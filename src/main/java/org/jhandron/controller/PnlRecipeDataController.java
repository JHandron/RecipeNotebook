package org.jhandron.controller;

import org.jhandron.*;

import javax.swing.DefaultListModel;
import java.util.Arrays;
import java.util.List;

public class PnlRecipeDataController implements RecipeSelectionListener {

    private final RecipeDataView view;
    private final DefaultListModel<String> lstMdlIngredients = new DefaultListModel<>();
    private final DefaultListModel<String> lstMdlTags = new DefaultListModel<>();
    private final RecipeTableModel tblMdlRelatedRecipes = new RecipeTableModel();

    public PnlRecipeDataController(RecipeDataView view) {
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

    public void handleIngredientsDeleted(List<String> ingredients) {
        removeTokensFromModel(ingredients, lstMdlIngredients);
    }

    public void handleTagsAdded(String p_input) {
        addTokensToModel(p_input, lstMdlTags);
    }

    public void handleTagsDeleted(List<String> tags) {
        removeTokensFromModel(tags, lstMdlTags);
    }

    public Recipe toRecipe(String recipeName, String instructions) {
        final Recipe recipe = new Recipe();
        if (recipeName != null) {
            recipe.setName(recipeName.trim());
        }
        if (instructions != null) {
            recipe.setInstructions(instructions.trim());
        }
        for (final Object ingredient : lstMdlIngredients.toArray()) {
            recipe.getIngredients().add((String) ingredient);
        }
        for (final Object tag : lstMdlTags.toArray()) {
            recipe.getTags().add((String) tag);
        }
        for (final Recipe relatedRecipe : tblMdlRelatedRecipes.getRecipes()) {
            recipe.getRelatedRecipeIds().add(relatedRecipe.getId());
        }
        return recipe;
    }

    public void populateFromRecipe(Recipe recipe) {
        if (recipe == null) {
            return;
        }

        view.setRecipeNameText(recipe.getName());
        view.setInstructionsText(recipe.getInstructions());

        lstMdlIngredients.clear();
        lstMdlTags.clear();
        tblMdlRelatedRecipes.clearModel();

        if (recipe.getIngredients() != null) {
            recipe.getIngredients().forEach(lstMdlIngredients::addElement);
        }
        if (recipe.getTags() != null) {
            recipe.getTags().forEach(lstMdlTags::addElement);
        }

        if (recipe.getRelatedRecipeIds() != null && !recipe.getRelatedRecipeIds().isEmpty()) {
            for (String relatedRecipeId : recipe.getRelatedRecipeIds()) {
                Recipe relatedRecipe = MongoDelegator.getRecipeById(relatedRecipeId);
                if (relatedRecipe != null) {
                    tblMdlRelatedRecipes.addRecipe(relatedRecipe);
                }
            }
        }
    }

    public void clearRecipeData() {
        lstMdlIngredients.clear();
        lstMdlTags.clear();
        tblMdlRelatedRecipes.clearModel();
    }

    public void handleSearchRequested() {
        view.openSearchDialog(this);
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

    private void removeTokensFromModel(List<String> tokens, DefaultListModel<String> model) {
        if (tokens == null || tokens.isEmpty()) {
            return;
        }
        for (String token : tokens) {
            model.removeElement(token);
        }
    }

    private void updateRelatedRecipesTable(List<Recipe> p_recipes) {
        tblMdlRelatedRecipes.clearModel();
        for (Recipe recipe : p_recipes) {
            tblMdlRelatedRecipes.addRecipe(recipe);
        }
    }
}

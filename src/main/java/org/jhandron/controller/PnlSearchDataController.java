package org.jhandron.controller;

import org.jhandron.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PnlSearchDataController {

    public enum SearchMode {
        NAME,
        INGREDIENTS,
        TAGS
    }

    private final SearchView view;
    private RecipeSelectionListener selectionListener;
    private final RecipeTableModel searchResultsModel = new RecipeTableModel();

    public PnlSearchDataController(SearchView view, RecipeSelectionListener selectionListener) {
        this.view = view;
        this.selectionListener = selectionListener;
    }

    public void initializeViewBindings() {
        view.bindSearchResultsTableModel(searchResultsModel);
    }

    public void handleSearch(SearchMode searchMode, String rawSearchText) {
        if (rawSearchText == null || rawSearchText.isBlank()) {
            searchResultsModel.clearModel();
            return;
        }

        final String searchText = rawSearchText.trim();
        Collection<Recipe> recipeSearchResults = switch (searchMode) {
            case NAME -> MongoDelegator.getCollectionByName(searchText);
            case INGREDIENTS -> MongoDelegator.getByInstructions(searchText);
            case TAGS -> MongoDelegator.getByTags(searchText);
        };
        if (recipeSearchResults.isEmpty()) {
            searchResultsModel.clearModel();
        } else {
            updateSearchTable(recipeSearchResults);
        }
    }

    public void setSelectionListener(RecipeSelectionListener selectionListener) {
        this.selectionListener = selectionListener;
    }

    public void handleRecipeSelection(int[] selectedRowIndexes) {
        if (selectedRowIndexes == null || selectedRowIndexes.length == 0) {
            return;
        }

        final List<Recipe> selectedRecipes = new ArrayList<>();
        for (int index : selectedRowIndexes) {
            Recipe recipe = searchResultsModel.getRecipeAt(index);
            if (recipe != null) {
                selectedRecipes.add(recipe);
            }
        }
        if (selectedRecipes.isEmpty()) {
            return;
        }

        selectionListener.onRecipesSelected(selectedRecipes);
        view.closeDialog();
    }

    public Recipe getRecipeAt(int rowIndex) {
        return searchResultsModel.getRecipeAt(rowIndex);
    }

    private void updateSearchTable(Collection<Recipe> results) {
        searchResultsModel.clearModel();
        for (Recipe recipe : results) {
            searchResultsModel.addRecipe(recipe);
        }
    }
}

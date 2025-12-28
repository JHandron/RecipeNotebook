package org.jhandron;

import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PnlSearchController {

    public enum SearchMode {
        NAME,
        INGREDIENTS,
        TAGS
    }

    private final SearchView view;
    private final RecipeSelectionListener selectionListener;
    private final RecipeTableModel searchResultsModel = new RecipeTableModel();

    public PnlSearchController(SearchView view, RecipeSelectionListener selectionListener) {
        this.view = view;
        this.selectionListener = selectionListener;
    }

    public void initializeViewBindings() {
        view.bindSearchResultsTableModel(searchResultsModel);
    }

    public void handleSearch(SearchDialogController.SearchMode searchMode, String rawSearchText) {
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

    public void handleRecipeSelection(int[] selectedRowIndexes) {
        List<Recipe> selectedRecipes = new ArrayList<>();
        for (int index : selectedRowIndexes) {
            selectedRecipes.add(searchResultsModel.getRecipeAt(index));
        }
        selectionListener.onRecipesSelected(selectedRecipes);
        view.closeDialog();
    }

    private void updateSearchTable(Collection<Recipe> results) {
        searchResultsModel.clearModel();
        for (Recipe recipe : results) {
            searchResultsModel.addRecipe(recipe);
        }
    }
}

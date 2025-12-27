package org.jhandron;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class RecipeTableModel extends AbstractTableModel {

    private List<Recipe> recipes = new ArrayList<>();
    public static final String[] COLUMN_NAMES = {"Id", "Name", "Ingredients", "Tags", "Related Recipes"};

    public void clearModel() {
        recipes.clear();
        fireTableDataChanged();
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
        fireTableDataChanged();
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
        fireTableRowsInserted(recipes.size() - 1, recipes.size() - 1);
    }

    public void removeRecipe(int index) {
        if (index >= 0 && index < recipes.size()) {
            recipes.remove(index);
            fireTableRowsDeleted(index, index);
        }
    }

    public Recipe getRecipeAt(int rowIndex) {
        if (rowIndex >= 0 && rowIndex < recipes.size()) {
            return recipes.get(rowIndex);
        }
        return null;
    }

    @Override
    public int getRowCount() {
        return recipes.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public String getColumnName(int p_index) {
        return COLUMN_NAMES[p_index];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Recipe recipe = recipes.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> recipe.getId();
            case 1 -> recipe.getName();
            case 2 -> recipe.getIngredientsFormattedString();
            case 3 -> recipe.getTagsFormattedString();
            case 4 -> recipe.getRelatedRecipeIds(); //TODO: Should use a formatted version?
            default -> null;
        };
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}

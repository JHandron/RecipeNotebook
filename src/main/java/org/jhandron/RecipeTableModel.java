package org.jhandron;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeTableModel extends AbstractTableModel {
    private List<Recipe> recipes = new ArrayList<>();
    //TODO:Hide the ID column
    public static final String[] COLUMN_NAMES = {"Id", "Name", "Ingredients", "Tags", "Related Recipes"};
    public static final HashMap<String, Integer> mapColumnHeaderToIndex = new HashMap<>();

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

//    @Override
//    public Class<?> getColumnClass(int columnIndex) {
//        switch (columnIndex) {
//            case 0: return String.class;
//            case 1: return String.class;
//            case 2: return Integer.class;
//            case 3: return String.class;
//            default: return Object.class;
//        }
//    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}

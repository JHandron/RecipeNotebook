package org.jhandron;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class RecipeTableModel extends AbstractTableModel {
    private final List<Recipe> recipes = new ArrayList<>();
    private static final String[] COLUMN_NAMES = {"Id", "Name", "Ingredients", "Tags", "Related Recipes"};
    
    public void addRecipe(Recipe p_recipe) {
        setValueAt(p_recipe.getId(), getRowCount(), 0);
        setValueAt(p_recipe.getName(), getRowCount(), 1);
        setValueAt(p_recipe.getIngredients(), getRowCount(), 2);
        setValueAt(p_recipe.getTags(), getRowCount(), 3);
        setValueAt(p_recipe.getRelatedRecipes(), getRowCount(), 4);
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
    public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
    }

    public void setRowCount(int i) {
    }
}

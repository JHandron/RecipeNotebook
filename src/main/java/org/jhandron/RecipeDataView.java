package org.jhandron;

import javax.swing.ListModel;
import javax.swing.table.TableModel;

public interface RecipeDataView {

    void bindIngredientListModel(ListModel<String> ingredientModel);

    void bindTagListModel(ListModel<String> tagModel);

    void bindRelatedRecipesTableModel(TableModel relatedRecipesModel);

    void openSearchDialog(RecipeSelectionListener selectionListener);

    String getRecipeNameText();

    void setRecipeNameText(String text);

    String getInstructionsText();

    void setInstructionsText(String text);
}

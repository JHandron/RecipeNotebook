package org.jhandron;

import javax.swing.table.TableModel;

public interface SearchDialogView {

    void bindSearchResultsTableModel(TableModel searchResultsModel);

    void closeDialog();
}

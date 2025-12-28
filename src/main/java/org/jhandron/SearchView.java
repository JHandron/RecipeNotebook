package org.jhandron;

import javax.swing.table.TableModel;

public interface SearchView {

    void bindSearchResultsTableModel(TableModel searchResultsModel);

    void closeDialog();
}

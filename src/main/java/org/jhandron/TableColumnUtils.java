package org.jhandron;

import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class TableColumnUtils {

    private TableColumnUtils() {
    }

    public static void hideColumns(JTable p_table, String... p_columnHeaders) {
        if (p_table == null || p_columnHeaders == null || p_columnHeaders.length == 0) {
            return;
        }

        final Set<String> headersToHide = new HashSet<>(Arrays.asList(p_columnHeaders));
        final TableColumnModel columnModel = p_table.getColumnModel();

        for (int index = 0; index < columnModel.getColumnCount(); index++) {
            final TableColumn column = columnModel.getColumn(index);
            final Object headerValue = column.getHeaderValue();

            if (headerValue != null && headersToHide.contains(headerValue.toString())) {
                hideColumn(column);
            }
        }
    }

    private static void hideColumn(TableColumn p_column) {
        p_column.setMinWidth(0);
        p_column.setMaxWidth(0);
        p_column.setPreferredWidth(0);
        p_column.setWidth(0);
        p_column.setResizable(false);
    }
}

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

    public static void hideColumns(JTable table, String... columnHeaders) {
        if (table == null || columnHeaders == null || columnHeaders.length == 0) {
            return;
        }

        final Set<String> headersToHide = new HashSet<>(Arrays.asList(columnHeaders));
        final TableColumnModel columnModel = table.getColumnModel();

        for (int index = 0; index < columnModel.getColumnCount(); index++) {
            final TableColumn column = columnModel.getColumn(index);
            final Object headerValue = column.getHeaderValue();

            if (headerValue != null && headersToHide.contains(headerValue.toString())) {
                hideColumn(column);
            }
        }
    }

    private static void hideColumn(TableColumn column) {
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column.setPreferredWidth(0);
        column.setWidth(0);
        column.setResizable(false);
    }
}

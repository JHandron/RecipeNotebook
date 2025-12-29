package org.jhandron;

import javax.swing.*;
import java.awt.*;

public class SearchDialog extends JDialog {

    public SearchDialog(Window owner, RecipeSelectionListener selectionListener) {
        super(owner, "Search Recipes", ModalityType.APPLICATION_MODAL);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        PnlSearch searchPanel = new PnlSearch(selectionListener, this::dispose);
        getContentPane().add(searchPanel, BorderLayout.CENTER);

        setPreferredSize(new Dimension(700, 500));
        pack();
        setLocationRelativeTo(owner);
    }
}

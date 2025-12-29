/*
 * Created by JFormDesigner on Mon Dec 29 17:36:22 EST 2025
 */

package org.jhandron;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.TableModel;

/**
 * @author Jason
 */
public class PnlSearch extends JPanel {

    private final PnlSearchController controller;

    public PnlSearch() {
        initComponents();
        controller = new PnlSearchController(this);
    }

    public PnlSearchData getSearchDataPanel() {
        return pnlSearchData1;
    }

    private void onViewRecipe(ActionEvent e) {
        controller.handleViewRecipe(getSelectedRecipeIndex());
    }

    private int[] getSelectedRecipeIndex() {
        return pnlSearchData1.getSelectedTableRows();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
        pnlSearchData1 = new PnlSearchData();
        panel1 = new JPanel();
        btnViewRecipe = new JButton();

        //======== this ========
        setLayout(new BorderLayout());
        add(pnlSearchData1, BorderLayout.CENTER);

        //======== panel1 ========
        {
            panel1.setLayout(new FlowLayout());

            //---- btnViewRecipe ----
            btnViewRecipe.setText("View Recipe");
            btnViewRecipe.addActionListener(e -> onViewRecipe(e));
            panel1.add(btnViewRecipe);
        }
        add(panel1, BorderLayout.SOUTH);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
    private PnlSearchData pnlSearchData1;
    private JPanel panel1;
    private JButton btnViewRecipe;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

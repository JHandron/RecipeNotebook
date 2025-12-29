/*
 * Created by JFormDesigner on Sun Dec 28 21:42:11 EST 2025
 */

package org.jhandron;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Jason
 */
public class DlgSearch extends JDialog {

    public DlgSearch(Window owner) {
        super(owner);
    }

    public DlgSearch(Window owner, RecipeSelectionListener p_selectionListener) {
        super(owner);
        initComponents();
        pnlSearchData1.setDialogContext(p_selectionListener, this::dispose);
    }

//    private void onSelectRecipes(ActionEvent e) {
//        List<Recipe> selectedRecipes = new ArrayList<>();
//        for (int index : selectedRowIndexes) {
//            selectedRecipes.add(searchResultsModel.getRecipeAt(index));
//        }
//        selectionListener.onRecipesSelected(selectedRecipes);
//        closeDialog();
//    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
        panel1 = new JPanel();
        button1 = new JButton();
        pnlSearchData1 = new PnlSearchData();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Search Recipes");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new FlowLayout());

            //---- button1 ----
            button1.setText("Select Recipe(s)");
            panel1.add(button1);
        }
        contentPane.add(panel1, BorderLayout.SOUTH);

        //---- pnlSearchData1 ----
        pnlSearchData1.setPreferredSize(new Dimension(380, 340));
        contentPane.add(pnlSearchData1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
    private JPanel panel1;
    private JButton button1;
    private PnlSearchData pnlSearchData1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

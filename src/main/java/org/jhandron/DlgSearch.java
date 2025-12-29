/*
 * Created by JFormDesigner on Sun Dec 28 21:42:11 EST 2025
 */

package org.jhandron;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author Jason
 */
public class DlgSearch extends JDialog {
    public DlgSearch(Window owner) {
        super(owner);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
        pnlSearch1 = new PnlSearch();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Search Recipes");
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //---- pnlSearch1 ----
        pnlSearch1.setPreferredSize(new Dimension(380, 325));
        pnlSearch1.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.add(pnlSearch1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
    private PnlSearch pnlSearch1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

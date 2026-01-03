/*
 * Created by JFormDesigner on Sun Dec 28 13:49:59 EST 2025
 */

package org.jhandron.view;

import java.awt.*;
import javax.swing.*;

/**
 * @author Jason
 */
public class PnlEdit extends JPanel {

    public PnlEdit() {
        initComponents();
    }

    public PnlRecipeData getRecipeDataPanel() {
        return pnlRecipeData1;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
        pnlRecipeData1 = new PnlRecipeData();
        panel1 = new JPanel();
        Update = new JButton();

        //======== this ========
        setLayout(new BorderLayout());
        add(pnlRecipeData1, BorderLayout.CENTER);

        //======== panel1 ========
        {
            panel1.setLayout(new FlowLayout());

            //---- Update ----
            Update.setText("Update Recipe");
            panel1.add(Update);
        }
        add(panel1, BorderLayout.SOUTH);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
    private PnlRecipeData pnlRecipeData1;
    private JPanel panel1;
    private JButton Update;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

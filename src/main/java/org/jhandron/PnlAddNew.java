/*
 * Created by JFormDesigner on Sun Dec 28 13:49:34 EST 2025
 */

package org.jhandron;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 * @author Jason
 */
public class PnlAddNew extends JPanel {

    private final PnlAddNewController controller;

    public PnlAddNew() {
        initComponents();
        controller = new PnlAddNewController(this);
    }

    private void onAddNewRecipe(ActionEvent e) {
        controller.handleAddNewRecipe(getRecipeNameText(), getInstructionsText());
    }

    public PnlRecipeData getRecipeDataPanel() {
        return pnlRecipeData1;
    }

    public String getRecipeNameText() {
        return pnlRecipeData1.getRecipeNameText();
    }

    public void setRecipeNameText(String text) {
        pnlRecipeData1.setRecipeNameText(text);
    }

    public String getInstructionsText() {
        return pnlRecipeData1.getInstructionsText();
    }

    public void setInstructionsText(String text) {
        pnlRecipeData1.setInstructionsText(text);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
        pnlRecipeData1 = new PnlRecipeData();
        panel1 = new JPanel();
        btnAddNew = new JButton();

        //======== this ========
        setLayout(new BorderLayout());
        add(pnlRecipeData1, BorderLayout.CENTER);

        //======== panel1 ========
        {
            panel1.setLayout(new FlowLayout());

            //---- btnAddNew ----
            btnAddNew.setText("Add New Recipe");
            btnAddNew.addActionListener(e -> onAddNewRecipe(e));
            panel1.add(btnAddNew);
        }
        add(panel1, BorderLayout.SOUTH);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
    private PnlRecipeData pnlRecipeData1;
    private JPanel panel1;
    private JButton btnAddNew;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

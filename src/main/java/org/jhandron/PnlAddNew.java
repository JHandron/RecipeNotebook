/*
 * Created by JFormDesigner on Sun Dec 28 13:49:34 EST 2025
 */

package org.jhandron;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author Jason
 */
public class PnlAddNew extends JPanel {
    public PnlAddNew() {
        initComponents();
    }

    public void setRecipeDataListener(PnlRecipeData.RecipeDataListener listener) {
        recipeDataPanel.setRecipeDataListener(listener);
    }

    public void setAddRecipeAction(ActionListener actionListener) {
        btnAddRecipe.addActionListener(actionListener);
    }

    public PnlRecipeData getRecipeDataPanel() {
        return recipeDataPanel;
    }

    public String getRecipeName() {
        return recipeDataPanel.getRecipeName();
    }

    public String getInstructions() {
        return recipeDataPanel.getInstructions();
    }

    public void clearForm() {
        recipeDataPanel.clearForm();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
        recipeDataPanel = new PnlRecipeData();
        pnlAddRecipeButton = new JPanel();
        btnAddRecipe = new JButton();

        //======== this ========
        setLayout(new BorderLayout());
        add(recipeDataPanel, BorderLayout.CENTER);

        //======== pnlAddRecipeButton ========
        {
            pnlAddRecipeButton.setLayout(new FlowLayout());

            //---- btnAddRecipe ----
            btnAddRecipe.setText("Add Recipe");
            pnlAddRecipeButton.add(btnAddRecipe);
        }
        add(pnlAddRecipeButton, BorderLayout.SOUTH);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
    private PnlRecipeData recipeDataPanel;
    private JPanel pnlAddRecipeButton;
    private JButton btnAddRecipe;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

/*
 * Created by JFormDesigner on Sun Dec 28 13:49:59 EST 2025
 */

package org.jhandron;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author Jason
 */
public class PnlEdit extends JPanel {
    public PnlEdit() {
        initComponents();
    }

    public void setRecipeDataListener(PnlRecipeData.RecipeDataListener listener) {
        recipeDataPanel.setRecipeDataListener(listener);
    }

    public void setPrimaryActionListener(ActionListener actionListener) {
        btnSaveRecipe.addActionListener(actionListener);
    }

    public void setPrimaryActionText(String text) {
        btnSaveRecipe.setText(text);
    }

    public PnlRecipeData getRecipeDataPanel() {
        return recipeDataPanel;
    }

    public void setRecipeNameEditable(boolean editable) {
        recipeDataPanel.setRecipeNameEditable(editable);
    }

    public void setRecipeName(String name) {
        recipeDataPanel.setRecipeName(name);
    }

    public String getRecipeName() {
        return recipeDataPanel.getRecipeName();
    }

    public String getInstructions() {
        return recipeDataPanel.getInstructions();
    }

    public void setInstructions(String instructions) {
        recipeDataPanel.setInstructions(instructions);
    }

    public void clearForm() {
        recipeDataPanel.clearForm();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
        recipeDataPanel = new PnlRecipeData();
        pnlSaveRecipeButton = new JPanel();
        btnSaveRecipe = new JButton();

        //======== this ========
        setLayout(new BorderLayout());
        add(recipeDataPanel, BorderLayout.CENTER);

        //======== pnlSaveRecipeButton ========
        {
            pnlSaveRecipeButton.setLayout(new FlowLayout());

            //---- btnSaveRecipe ----
            btnSaveRecipe.setText("Save Recipe");
            pnlSaveRecipeButton.add(btnSaveRecipe);
        }
        add(pnlSaveRecipeButton, BorderLayout.SOUTH);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
    private PnlRecipeData recipeDataPanel;
    private JPanel pnlSaveRecipeButton;
    private JButton btnSaveRecipe;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

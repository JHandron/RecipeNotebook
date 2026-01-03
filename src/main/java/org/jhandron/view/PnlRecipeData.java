/*
 * Created by JFormDesigner on Sun Dec 28 13:50:33 EST 2025
 */

package org.jhandron.view;

import org.jhandron.*;
import org.jhandron.controller.PnlRecipeDataController;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * @author Jason
 */
public class PnlRecipeData extends JPanel implements RecipeDataView {

    private final PnlRecipeDataController controller;

    public PnlRecipeData() {
        controller = new PnlRecipeDataController(this);
        initComponents();
        init();
    }

    public void init() {
        controller.initializeViewBindings();
        hideColumns();
    }

    private void txtAddIngredientsEntered(ActionEvent e) {
        addIngredients(e);
    }

    private void deleteIngredients(ActionEvent e) {
        controller.handleIngredientsDeleted(lstIngredients.getSelectedValuesList());
    }

    private void addIngredients(ActionEvent e) {
        controller.handleIngredientsAdded(txtAddIngredients.getText());
        txtAddIngredients.setText("");
    }

    private void txtAddTagsEntered(ActionEvent e) {
        addTags(e);
    }

    private void deleteTags(ActionEvent e) {
        controller.handleTagsDeleted(lstTags.getSelectedValuesList());
    }

    private void addTags(ActionEvent e) {
        controller.handleTagsAdded(txtAddTags.getText());
        txtAddTags.setText("");
    }

    private void spawnSearchDialog(ActionEvent e) {
        controller.handleSearchRequested();
    }

    @Override
    public void bindIngredientListModel(ListModel<String> p_ingredientModel) {
        lstIngredients.setModel(p_ingredientModel);
    }

    @Override
    public void bindTagListModel(ListModel<String> p_tagModel) {
        lstTags.setModel(p_tagModel);
    }

    @Override
    public void bindRelatedRecipesTableModel(TableModel p_relatedRecipesModel) {
        tblRelatedRecipes.setModel(p_relatedRecipesModel);
    }

    @Override
    public void openSearchDialog(RecipeSelectionListener p_selectionListener) {
        Window owner = SwingUtilities.getWindowAncestor(this);
        DlgSearch searchDialog = new DlgSearch(owner, p_selectionListener);
        searchDialog.setVisible(true);
    }

    @Override
    public String getRecipeNameText() {
        return txtAddRecipeName.getText();
    }

    @Override
    public void setRecipeNameText(String text) {
        txtAddRecipeName.setText(text);
    }

    @Override
    public String getInstructionsText() {
        return txtarAddInstructions.getText();
    }

    @Override
    public void setInstructionsText(String text) {
        txtarAddInstructions.setText(text);
    }

    private void hideColumns() {
        TableColumnUtils.hideColumns(tblRelatedRecipes,
                RecipeTableModel.COLUMN_NAMES[0], // Id
                RecipeTableModel.COLUMN_NAMES[2], // Ingredients
                RecipeTableModel.COLUMN_NAMES[3], // Tags
                RecipeTableModel.COLUMN_NAMES[4]  // Related Recipes
        );
    }

    public PnlRecipeDataController getController() {
        return controller;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
        panel1 = new JPanel();
        label1 = new JLabel();
        txtAddRecipeName = new JTextField();
        pnlIngredientsTags = new JPanel();
        pnlIngredients = new JPanel();
        lblIngredients = new JLabel();
        txtAddIngredients = new JTextField();
        spIngredients = new JScrollPane();
        lstIngredients = new JList<>();
        btnAddIngredients = new JButton();
        btnDeleteIngredients = new JButton();
        pnlTags = new JPanel();
        spTags = new JScrollPane();
        lstTags = new JList<>();
        lblTags = new JLabel();
        txtAddTags = new JTextField();
        btnAddTags = new JButton();
        btnDeleteTags = new JButton();
        pnlInstructionsRelatedRecipes = new JPanel();
        panel4 = new JPanel();
        label3 = new JLabel();
        spInstructions = new JScrollPane();
        txtarAddInstructions = new JTextArea();
        panel7 = new JPanel();
        label4 = new JLabel();
        scrollPane1 = new JScrollPane();
        tblRelatedRecipes = new JTable();
        panel3 = new JPanel();
        button1 = new JButton();

        //======== this ========
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //======== panel1 ========
        {
            panel1.setBorder(new EmptyBorder(5, 5, 5, 5));

            //---- label1 ----
            label1.setText("Recipe Name");
            label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(txtAddRecipeName, GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label1)
                                .addGap(0, 524, Short.MAX_VALUE)))
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(label1)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAddRecipeName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
            );
        }
        add(panel1);

        //======== pnlIngredientsTags ========
        {
            pnlIngredientsTags.setLayout(new BoxLayout(pnlIngredientsTags, BoxLayout.X_AXIS));

            //======== pnlIngredients ========
            {
                pnlIngredients.setBorder(new EmptyBorder(5, 5, 5, 5));

                //---- lblIngredients ----
                lblIngredients.setText("Ingredient(s)");
                lblIngredients.setFont(lblIngredients.getFont().deriveFont(lblIngredients.getFont().getStyle() | Font.BOLD));

                //---- txtAddIngredients ----
                txtAddIngredients.setToolTipText("Enter single ingredient or as comma separated values");
                txtAddIngredients.addActionListener(e -> txtAddIngredientsEntered(e));

                //======== spIngredients ========
                {
                    spIngredients.setViewportView(lstIngredients);
                }

                //---- btnAddIngredients ----
                btnAddIngredients.setText("\u2013");
                btnAddIngredients.setFont(btnAddIngredients.getFont().deriveFont(btnAddIngredients.getFont().getStyle() | Font.BOLD));
                btnAddIngredients.addActionListener(e -> deleteIngredients(e));

                //---- btnDeleteIngredients ----
                btnDeleteIngredients.setText("+");
                btnDeleteIngredients.setFont(btnDeleteIngredients.getFont().deriveFont(btnDeleteIngredients.getFont().getStyle() | Font.BOLD));
                btnDeleteIngredients.addActionListener(e -> addIngredients(e));

                GroupLayout pnlIngredientsLayout = new GroupLayout(pnlIngredients);
                pnlIngredients.setLayout(pnlIngredientsLayout);
                pnlIngredientsLayout.setHorizontalGroup(
                    pnlIngredientsLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, pnlIngredientsLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(pnlIngredientsLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(pnlIngredientsLayout.createSequentialGroup()
                                    .addComponent(txtAddIngredients)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnDeleteIngredients)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnAddIngredients))
                                .addComponent(lblIngredients, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spIngredients))
                            .addContainerGap())
                );
                pnlIngredientsLayout.setVerticalGroup(
                    pnlIngredientsLayout.createParallelGroup()
                        .addGroup(pnlIngredientsLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblIngredients)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(pnlIngredientsLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(txtAddIngredients, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(pnlIngredientsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAddIngredients)
                                    .addComponent(btnDeleteIngredients)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(spIngredients, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
            }
            pnlIngredientsTags.add(pnlIngredients);

            //======== pnlTags ========
            {
                pnlTags.setBorder(new EmptyBorder(5, 5, 5, 5));

                //======== spTags ========
                {
                    spTags.setViewportView(lstTags);
                }

                //---- lblTags ----
                lblTags.setText("Tag(s)");
                lblTags.setFont(lblTags.getFont().deriveFont(lblTags.getFont().getStyle() | Font.BOLD));

                //---- txtAddTags ----
                txtAddTags.setToolTipText("Enter single tag or as comma separated values");
                txtAddTags.addActionListener(e -> txtAddTagsEntered(e));

                //---- btnAddTags ----
                btnAddTags.setText("\u2013");
                btnAddTags.setFont(btnAddTags.getFont().deriveFont(btnAddTags.getFont().getStyle() | Font.BOLD));
                btnAddTags.addActionListener(e -> deleteTags(e));

                //---- btnDeleteTags ----
                btnDeleteTags.setText("+");
                btnDeleteTags.setFont(btnDeleteTags.getFont().deriveFont(btnDeleteTags.getFont().getStyle() | Font.BOLD));
                btnDeleteTags.addActionListener(e -> addTags(e));

                GroupLayout pnlTagsLayout = new GroupLayout(pnlTags);
                pnlTags.setLayout(pnlTagsLayout);
                pnlTagsLayout.setHorizontalGroup(
                    pnlTagsLayout.createParallelGroup()
                        .addGroup(pnlTagsLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(pnlTagsLayout.createParallelGroup()
                                .addGroup(pnlTagsLayout.createSequentialGroup()
                                    .addComponent(txtAddTags)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnDeleteTags)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnAddTags))
                                .addComponent(lblTags, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spTags, GroupLayout.Alignment.TRAILING))
                            .addContainerGap())
                );
                pnlTagsLayout.setVerticalGroup(
                    pnlTagsLayout.createParallelGroup()
                        .addGroup(pnlTagsLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblTags)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(pnlTagsLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(pnlTagsLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtAddTags, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDeleteTags))
                                .addComponent(btnAddTags))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(spTags, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
            }
            pnlIngredientsTags.add(pnlTags);
        }
        add(pnlIngredientsTags);

        //======== pnlInstructionsRelatedRecipes ========
        {
            pnlInstructionsRelatedRecipes.setLayout(new BoxLayout(pnlInstructionsRelatedRecipes, BoxLayout.X_AXIS));

            //======== panel4 ========
            {
                panel4.setBorder(new EmptyBorder(5, 5, 5, 5));
                panel4.setPreferredSize(new Dimension(142, 218));

                //---- label3 ----
                label3.setText("Instructions");
                label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD));

                //======== spInstructions ========
                {

                    //---- txtarAddInstructions ----
                    txtarAddInstructions.setLineWrap(true);
                    txtarAddInstructions.setWrapStyleWord(true);
                    txtarAddInstructions.setMinimumSize(null);
                    txtarAddInstructions.setPreferredSize(null);
                    spInstructions.setViewportView(txtarAddInstructions);
                }

                GroupLayout panel4Layout = new GroupLayout(panel4);
                panel4.setLayout(panel4Layout);
                panel4Layout.setHorizontalGroup(
                    panel4Layout.createParallelGroup()
                        .addGroup(panel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel4Layout.createParallelGroup()
                                .addComponent(label3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spInstructions))
                            .addContainerGap())
                );
                panel4Layout.setVerticalGroup(
                    panel4Layout.createParallelGroup()
                        .addGroup(panel4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label3)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(spInstructions, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addContainerGap())
                );
            }
            pnlInstructionsRelatedRecipes.add(panel4);

            //======== panel7 ========
            {
                panel7.setBorder(new EmptyBorder(5, 5, 5, 5));
                panel7.setPreferredSize(new Dimension(142, 218));

                //---- label4 ----
                label4.setText("Related Recipes");
                label4.setFont(label4.getFont().deriveFont(label4.getFont().getStyle() | Font.BOLD));

                //======== scrollPane1 ========
                {
                    scrollPane1.setPreferredSize(new Dimension(0, 0));

                    //---- tblRelatedRecipes ----
                    tblRelatedRecipes.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            null
                        }
                    ));
                    tblRelatedRecipes.setPreferredSize(null);
                    scrollPane1.setViewportView(tblRelatedRecipes);
                }

                //======== panel3 ========
                {
                    panel3.setPreferredSize(null);
                    panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

                    //---- button1 ----
                    button1.setText("Search...");
                    button1.addActionListener(e -> spawnSearchDialog(e));
                    panel3.add(button1);
                }

                GroupLayout panel7Layout = new GroupLayout(panel7);
                panel7.setLayout(panel7Layout);
                panel7Layout.setHorizontalGroup(
                    panel7Layout.createParallelGroup()
                        .addGroup(panel7Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel7Layout.createParallelGroup()
                                .addComponent(label4, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE)
                                .addComponent(panel3, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(scrollPane1, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 288, Short.MAX_VALUE))
                            .addContainerGap())
                );
                panel7Layout.setVerticalGroup(
                    panel7Layout.createParallelGroup()
                        .addGroup(panel7Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label4)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(scrollPane1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                );
            }
            pnlInstructionsRelatedRecipes.add(panel7);
        }
        add(pnlInstructionsRelatedRecipes);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
    private JPanel panel1;
    private JLabel label1;
    private JTextField txtAddRecipeName;
    private JPanel pnlIngredientsTags;
    private JPanel pnlIngredients;
    private JLabel lblIngredients;
    private JTextField txtAddIngredients;
    private JScrollPane spIngredients;
    private JList<String> lstIngredients;
    private JButton btnAddIngredients;
    private JButton btnDeleteIngredients;
    private JPanel pnlTags;
    private JScrollPane spTags;
    private JList<String> lstTags;
    private JLabel lblTags;
    private JTextField txtAddTags;
    private JButton btnAddTags;
    private JButton btnDeleteTags;
    private JPanel pnlInstructionsRelatedRecipes;
    private JPanel panel4;
    private JLabel label3;
    private JScrollPane spInstructions;
    private JTextArea txtarAddInstructions;
    private JPanel panel7;
    private JLabel label4;
    private JScrollPane scrollPane1;
    private JTable tblRelatedRecipes;
    private JPanel panel3;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

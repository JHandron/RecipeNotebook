package org.jhandron;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author Jason
 */

public class RecipeNotebookGUI extends JFrame implements RecipeNotebookView {

    private final RecipeNotebookController controller;

    public RecipeNotebookGUI() {
        controller = new RecipeNotebookController(this);
        initComponents();
        init();
    }

    private void init() {
        controller.initializeViewBindings();
//        hideColumns();
    }

//    private void hideColumns() {
//        TableColumnUtils.hideColumns(tblRelatedRecipes,
//            RecipeTableModel.COLUMN_NAMES[0], // Id
//            RecipeTableModel.COLUMN_NAMES[2], // Ingredients
//            RecipeTableModel.COLUMN_NAMES[3], // Tags
//            RecipeTableModel.COLUMN_NAMES[4]  // Related Recipes
//        );
//    }
//
//    private void addNewRecipe(ActionEvent e) {
//        controller.handleAddNewRecipe(txtAddRecipeName.getText(), txtarAddInstructions.getText());
//    }
//
//    private void addIngredients(ActionEvent e) {
//        controller.handleIngredientsAdded(txtAddIngredients.getText());
//        txtAddIngredients.setText("");
//    }
//
//    private void txtAddIngredientsEntered(ActionEvent e) {
//        addIngredients(e);
//    }
//
//    private void addTags(ActionEvent e) {
//        controller.handleTagsAdded(txtAddTags.getText());
//        txtAddTags.setText("");
//    }
//
//    private void txtAddTagsEntered(ActionEvent e) {
//        addTags(e);
//    }
//
//    private void deleteIngredients(ActionEvent e) {
//        controller.handleIngredientsDeleted(lstIngredients.getSelectedValuesList());
//    }
//
//    private void deleteTags(ActionEvent e) {
//        controller.handleTagsDeleted(lstTags.getSelectedValuesList());
//    }
//
    private void exitMenuItem(ActionEvent e) {
        controller.handleExitRequested();
    }
//
//    private void spawnSearchDialog(ActionEvent e) {
//        controller.handleSearchRequested();
//    }
//
    @Override
    public void bindIngredientListModel(ListModel<String> p_ingredientModel) {
//        lstIngredients.setModel(p_ingredientModel);
    }

    @Override
    public void bindTagListModel(ListModel<String> p_tagModel) {
//        lstTags.setModel(p_tagModel);
    }

    @Override
    public void bindRelatedRecipesTableModel(TableModel p_relatedRecipesModel) {
//        tblRelatedRecipes.setModel(p_relatedRecipesModel);
    }

    @Override
    public void openSearchDialog(RecipeSelectionListener p_selectionListener) {
        SearchDialogGUI dialog = new SearchDialogGUI(this, p_selectionListener);
        dialog.setVisible(true);
    }

    @Override
    public void exitApplication() {
        System.exit(0);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem3 = new JMenuItem();
        pnlMain = new JPanel();
        pnlMainCard = new JPanel();
        pnlSearch1 = new PnlSearch();
        pnlAddNew1 = new PnlAddNew();
        pnlEdit1 = new PnlEdit();

        //======== this ========
        setTitle("Jason's Recipe Notebook");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon("C:\\Users\\Jason\\Documents\\Projects\\RecipeNotebook\\src\\onkoyybdqdc81.png").getImage());
        setPreferredSize(new Dimension(595, 535));
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("File");

                //---- menuItem3 ----
                menuItem3.setText("Exit");
                menuItem3.addActionListener(e -> exitMenuItem(e));
                menu1.add(menuItem3);
            }
            menuBar1.add(menu1);
        }
        setJMenuBar(menuBar1);

        //======== pnlMain ========
        {
            pnlMain.setMinimumSize(new Dimension(0, 0));
            pnlMain.setLayout(new BorderLayout());

            //======== pnlMainCard ========
            {
                pnlMainCard.setLayout(new CardLayout());
                pnlMainCard.add(pnlSearch1, "card3");
                pnlMainCard.add(pnlAddNew1, "card1");
                pnlMainCard.add(pnlEdit1, "card2");
            }
            pnlMain.add(pnlMainCard, BorderLayout.CENTER);
        }
        contentPane.add(pnlMain, BorderLayout.CENTER);
        setSize(595, 535);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem3;
    private JPanel pnlMain;
    private JPanel pnlMainCard;
    private PnlSearch pnlSearch1;
    private PnlAddNew pnlAddNew1;
    private PnlEdit pnlEdit1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

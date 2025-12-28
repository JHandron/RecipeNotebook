package org.jhandron;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.*;
import javax.swing.table.TableModel;

/**
 * Main application frame that hosts the Add/Edit/Search panels and wires them to the controller.
 * The Add and Edit screens share a single recipe data form via {@link PnlRecipeData}.
 */
public class RecipeNotebookGUI extends JFrame implements RecipeNotebookView {

    private static final String CARD_ADD = "add";
    private static final String CARD_EDIT = "edit";
    private static final String CARD_SEARCH = "search";

    private final RecipeNotebookController controller;
    private CardLayout mainLayout;

    public RecipeNotebookGUI() {
        controller = new RecipeNotebookController(this);
        initComponents();
        init();
    }

    private void init() {
        wireRecipeDataPanels();
        controller.initializeViewBindings();
        hideColumns();
        showAddScreen();
    }

    private void wireRecipeDataPanels() {
        PnlRecipeData.RecipeDataListener sharedListener = new PnlRecipeData.RecipeDataListener() {
            @Override
            public void onAddIngredients(String input) {
                controller.handleIngredientsAdded(input);
            }

            @Override
            public void onDeleteIngredients(List<String> ingredients) {
                controller.handleIngredientsDeleted(ingredients);
            }

            @Override
            public void onAddTags(String input) {
                controller.handleTagsAdded(input);
            }

            @Override
            public void onDeleteTags(List<String> tags) {
                controller.handleTagsDeleted(tags);
            }

            @Override
            public void onSearchRelatedRecipes() {
                controller.handleSearchRequested();
            }
        };

        pnlAddNew.setRecipeDataListener(sharedListener);
        pnlEdit.setRecipeDataListener(sharedListener);

        pnlAddNew.setAddRecipeAction(this::addNewRecipe);
        pnlEdit.setPrimaryActionListener(e -> {
            // Future: wire update handler when the edit workflow is available.
        });
    }

    private void hideColumns() {
        JTable addTable = pnlAddNew.getRecipeDataPanel().getRelatedRecipesTable();
        JTable editTable = pnlEdit.getRecipeDataPanel().getRelatedRecipesTable();

        TableColumnUtils.hideColumns(addTable,
            RecipeTableModel.COLUMN_NAMES[0], // Id
            RecipeTableModel.COLUMN_NAMES[2], // Ingredients
            RecipeTableModel.COLUMN_NAMES[3], // Tags
            RecipeTableModel.COLUMN_NAMES[4]  // Related Recipes
        );
        TableColumnUtils.hideColumns(editTable,
            RecipeTableModel.COLUMN_NAMES[0], // Id
            RecipeTableModel.COLUMN_NAMES[2], // Ingredients
            RecipeTableModel.COLUMN_NAMES[3], // Tags
            RecipeTableModel.COLUMN_NAMES[4]  // Related Recipes
        );
    }

    private void addNewRecipe(ActionEvent e) {
        controller.handleAddNewRecipe(pnlAddNew.getRecipeName(), pnlAddNew.getInstructions());
        pnlAddNew.clearForm();
    }

    private void exitMenuItem(ActionEvent e) {
        controller.handleExitRequested();
    }

    private void showAddScreen() {
        mainLayout.show(pnlMain, CARD_ADD);
    }

    @SuppressWarnings("unused")
    private void showEditScreen() {
        mainLayout.show(pnlMain, CARD_EDIT);
    }

    @SuppressWarnings("unused")
    private void showSearchScreen() {
        mainLayout.show(pnlMain, CARD_SEARCH);
    }

    @Override
    public void bindIngredientListModel(ListModel<String> ingredientModel) {
        pnlAddNew.getRecipeDataPanel().bindIngredientListModel(ingredientModel);
        pnlEdit.getRecipeDataPanel().bindIngredientListModel(ingredientModel);
    }

    @Override
    public void bindTagListModel(ListModel<String> tagModel) {
        pnlAddNew.getRecipeDataPanel().bindTagListModel(tagModel);
        pnlEdit.getRecipeDataPanel().bindTagListModel(tagModel);
    }

    @Override
    public void bindRelatedRecipesTableModel(TableModel relatedRecipesModel) {
        pnlAddNew.getRecipeDataPanel().bindRelatedRecipesTableModel(relatedRecipesModel);
        pnlEdit.getRecipeDataPanel().bindRelatedRecipesTableModel(relatedRecipesModel);
    }

    @Override
    public void openSearchDialog(RecipeSelectionListener selectionListener) {
        SearchDialogGUI dialog = new SearchDialogGUI(this, selectionListener);
        dialog.setVisible(true);
    }

    @Override
    public void exitApplication() {
        System.exit(0);
    }

    private void initComponents() {
        menuBar = new JMenuBar();
        fileMenu = new JMenu();
        exitMenuItem = new JMenuItem();
        pnlMain = new JPanel();
        pnlAddNew = new PnlAddNew();
        pnlEdit = new PnlEdit();
        pnlSearch = new PnlSearch();

        //======== this ========
        setTitle("Jason's Recipe Notebook");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(595, 535));
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menu ========
        {
            fileMenu.setText("File");

            exitMenuItem.setText("Exit");
            exitMenuItem.addActionListener(this::exitMenuItem);
            fileMenu.add(exitMenuItem);
            menuBar.add(fileMenu);
        }
        setJMenuBar(menuBar);

        //======== pnlMain ========
        {
            mainLayout = new CardLayout();
            pnlMain.setLayout(mainLayout);
            pnlMain.add(pnlAddNew, CARD_ADD);
            pnlMain.add(pnlEdit, CARD_EDIT);
            pnlMain.add(pnlSearch, CARD_SEARCH);
        }
        contentPane.add(pnlMain, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
    }

    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem exitMenuItem;
    private JPanel pnlMain;
    private PnlAddNew pnlAddNew;
    private PnlEdit pnlEdit;
    private PnlSearch pnlSearch;
}

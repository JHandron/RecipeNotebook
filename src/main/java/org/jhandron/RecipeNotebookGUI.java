package org.jhandron;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * @author Jason
 */

public class RecipeNotebookGUI extends JFrame implements RecipeSelectionListener {

    private final DefaultListModel<String> lstMdlIngredients = new DefaultListModel<>();
    private final DefaultListModel<String> lstMdlTags = new DefaultListModel<>();
    private final RecipeTableModel tblMdlRelatedRecipes = new RecipeTableModel();

    public RecipeNotebookGUI() {
        initComponents();
        init();
    }

    private void init() {
        tblMdlRelatedRecipes.getRecipes().clear();
        tblRelatedRecipes.setModel(tblMdlRelatedRecipes);
    }

    private void addNewRecipe(ActionEvent e) {
        final Recipe recipe = new Recipe();
        recipe.setName(txtAddRecipeName.getText().trim()); //TODO:Better input sanitization
        recipe.setInstructions(txtarAddInstructions.getText().trim());

        for (final Object o : lstMdlIngredients.toArray()) {
            recipe.getIngredients().add((String)o);
        }
        for (final Object o : lstMdlTags.toArray()) {
            recipe.getTags().add((String)o);
        }
        for (final Recipe relatedRecipe : tblMdlRelatedRecipes.getRecipes()) {
            recipe.getRelatedRecipeIds().add(relatedRecipe.getId());
        }
        MongoDelegator.doInsert(recipe);
    }

    private void updateIngredientsList(){
        lstIngredients.setModel(lstMdlIngredients);
    }

    private void updateTagsList(){
        lstTags.setModel(lstMdlTags);
    }

    private void txtAddIngredientsEnter(ActionEvent e) {
        lstMdlIngredients.addElement(txtAddIngredients.getText().trim());
        txtAddIngredients.setText("");
        updateIngredientsList();
    }

    private void txtAddTagsEntered(ActionEvent e) {
        lstMdlTags.addElement(txtAddTags.getText().trim());
        txtAddTags.setText("");
        updateTagsList();
    }

    private void lstIngredientsMouseClicked(MouseEvent e) {
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem deleteItem = new JMenuItem("Delete");
        popupMenu.add(deleteItem);

        // Add mouse listener for right-click popup
        lstIngredients.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                showPopup(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                showPopup(e);
            }

            private void showPopup(MouseEvent e) {
                if (e.isPopupTrigger()) { // Detect right-click trigger
                    int index = lstIngredients.locationToIndex(e.getPoint());
                    if (index != -1) {
                        lstIngredients.setSelectedIndex(index); // Highlight selection
                        popupMenu.show(lstIngredients, e.getX(), e.getY());
                    }
                }
            }
        });

        deleteItem.addActionListener(o -> {
            int selectedIndex = lstIngredients.getSelectedIndex();
            if (selectedIndex != -1) {
                lstMdlIngredients.remove(selectedIndex);
                updateIngredientsList();
            }
        });
    }

    private void exitMenuItem(ActionEvent e) {
        System.exit(0);
    }

    private void spawnSearchDialog(ActionEvent e) {
        SearchDialog dialog = new SearchDialog(this, this);
        dialog.setRecipeSelectionListener(this);
        dialog.setVisible(true);
    }

    public void onRecipesSelected(List<Recipe> p_recipes) {
        System.out.println("Recipes selected: " + p_recipes);
        updateRelatedRecipesTable(p_recipes);
    }

    public void updateRelatedRecipesTable(List<Recipe> p_recipes) {
        tblMdlRelatedRecipes.clearModel(); //clear prior results
        for (Recipe recipe : p_recipes){
            tblMdlRelatedRecipes.addRecipe(recipe);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menuItem2 = new JMenuItem();
        tabbedPane1 = new JTabbedPane();
        pnlAddNew = new JPanel();
        lblRecipeName = new JLabel();
        txtAddRecipeName = new JTextField();
        label1 = new JLabel();
        txtAddIngredients = new JTextField();
        panel4 = new JPanel();
        spIngredients = new JScrollPane();
        lstIngredients = new JList<>();
        label2 = new JLabel();
        txtAddTags = new JTextField();
        panel2 = new JPanel();
        spTags = new JScrollPane();
        lstTags = new JList<>();
        panel1 = new JPanel();
        spInstructions = new JScrollPane();
        txtarAddInstructions = new JTextArea();
        panel3 = new JPanel();
        scrollPane1 = new JScrollPane();
        tblRelatedRecipes = new JTable();
        button1 = new JButton();
        btnAddRecipe = new JButton();

        //======== this ========
        setTitle("Jason's Recipe Notebook");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("File");

                //---- menuItem1 ----
                menuItem1.setText("Import Recipe");
                menu1.add(menuItem1);

                //---- menuItem3 ----
                menuItem3.setText("Generate PDF");
                menu1.add(menuItem3);
                menu1.addSeparator();

                //---- menuItem2 ----
                menuItem2.setText("Exit");
                menuItem2.addActionListener(e -> exitMenuItem(e));
                menu1.add(menuItem2);
            }
            menuBar1.add(menu1);
        }
        setJMenuBar(menuBar1);

        //======== tabbedPane1 ========
        {
            tabbedPane1.setTabPlacement(SwingConstants.LEFT);

            //======== pnlAddNew ========
            {
                pnlAddNew.setLayout(new GridBagLayout());
                ((GridBagLayout)pnlAddNew.getLayout()).columnWidths = new int[] {375, 240, 0};
                ((GridBagLayout)pnlAddNew.getLayout()).rowHeights = new int[] {71, 121, 110, 183, 45, 0};
                ((GridBagLayout)pnlAddNew.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
                ((GridBagLayout)pnlAddNew.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0, 0.0, 1.0E-4};

                //---- lblRecipeName ----
                lblRecipeName.setText("Recipe Name");
                pnlAddNew.add(lblRecipeName, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.WEST, GridBagConstraints.NONE,
                    new Insets(10, 15, 5, 5), 0, 0));
                pnlAddNew.add(txtAddRecipeName, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(10, 100, 5, 10), 0, 0));

                //---- label1 ----
                label1.setText("Ingredient(s)");
                pnlAddNew.add(label1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.WEST, GridBagConstraints.NONE,
                    new Insets(0, 15, 5, 5), 0, 0));

                //---- txtAddIngredients ----
                txtAddIngredients.setToolTipText("Press Enter to add an ingredient");
                txtAddIngredients.addActionListener(e -> txtAddIngredientsEnter(e));
                pnlAddNew.add(txtAddIngredients, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 100, 5, 15), 0, 0));

                //======== panel4 ========
                {
                    panel4.setBorder(new TitledBorder("Ingredients"));
                    panel4.setOpaque(false);
                    panel4.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel4.getLayout()).columnWidths = new int[] {240, 0};
                    ((GridBagLayout)panel4.getLayout()).rowHeights = new int[] {114, 0};
                    ((GridBagLayout)panel4.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                    ((GridBagLayout)panel4.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                    //======== spIngredients ========
                    {

                        //---- lstIngredients ----
                        lstIngredients.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                lstIngredientsMouseClicked(e);
                            }
                        });
                        spIngredients.setViewportView(lstIngredients);
                    }
                    panel4.add(spIngredients, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                pnlAddNew.add(panel4, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 5, 10), 0, 0));

                //---- label2 ----
                label2.setText("Tag(s)");
                pnlAddNew.add(label2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.WEST, GridBagConstraints.NONE,
                    new Insets(0, 15, 5, 5), 0, 0));

                //---- txtAddTags ----
                txtAddTags.setToolTipText("Press Enter to add a tag");
                txtAddTags.addActionListener(e -> txtAddTagsEntered(e));
                pnlAddNew.add(txtAddTags, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 100, 5, 15), 0, 0));

                //======== panel2 ========
                {
                    panel2.setBorder(new TitledBorder("Tags"));
                    panel2.setRequestFocusEnabled(false);
                    panel2.setPreferredSize(null);
                    panel2.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {240, 0};
                    ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {124, 0};
                    ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                    ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                    //======== spTags ========
                    {
                        spTags.setViewportView(lstTags);
                    }
                    panel2.add(spTags, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                pnlAddNew.add(panel2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 0, 5, 10), 0, 0));

                //======== panel1 ========
                {
                    panel1.setBorder(new TitledBorder("Instructions"));
                    panel1.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {158, 162, 0};
                    ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {193, 0};
                    ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
                    ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

                    //======== spInstructions ========
                    {

                        //---- txtarAddInstructions ----
                        txtarAddInstructions.setLineWrap(true);
                        txtarAddInstructions.setWrapStyleWord(true);
                        txtarAddInstructions.setMinimumSize(null);
                        spInstructions.setViewportView(txtarAddInstructions);
                    }
                    panel1.add(spInstructions, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                pnlAddNew.add(panel1, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                    new Insets(0, 15, 5, 10), 0, 0));

                //======== panel3 ========
                {
                    panel3.setBorder(new TitledBorder("Related Recipes"));
                    panel3.setMinimumSize(null);
                    panel3.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel3.getLayout()).columnWidths = new int[] {205, 0};
                    ((GridBagLayout)panel3.getLayout()).rowHeights = new int[] {138, 0, 0};
                    ((GridBagLayout)panel3.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                    ((GridBagLayout)panel3.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0E-4};

                    //======== scrollPane1 ========
                    {

                        //---- tblRelatedRecipes ----
                        tblRelatedRecipes.setModel(new DefaultTableModel(
                            new Object[][] {
                            },
                            new String[] {
                                null
                            }
                        ));
                        scrollPane1.setViewportView(tblRelatedRecipes);
                    }
                    panel3.add(scrollPane1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));

                    //---- button1 ----
                    button1.setText("Search...");
                    button1.addActionListener(e -> spawnSearchDialog(e));
                    panel3.add(button1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                pnlAddNew.add(panel3, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 10), 0, 0));

                //---- btnAddRecipe ----
                btnAddRecipe.setText("Add Recipe");
                btnAddRecipe.addActionListener(e -> addNewRecipe(e));
                pnlAddNew.add(btnAddRecipe, new GridBagConstraints(0, 4, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.NONE,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            tabbedPane1.addTab("Add New ", pnlAddNew);
        }
        contentPane.add(tabbedPane1, BorderLayout.CENTER);
        setSize(700, 650);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem3;
    private JMenuItem menuItem2;
    private JTabbedPane tabbedPane1;
    private JPanel pnlAddNew;
    private JLabel lblRecipeName;
    private JTextField txtAddRecipeName;
    private JLabel label1;
    private JTextField txtAddIngredients;
    private JPanel panel4;
    private JScrollPane spIngredients;
    private JList<String> lstIngredients;
    private JLabel label2;
    private JTextField txtAddTags;
    private JPanel panel2;
    private JScrollPane spTags;
    private JList<String> lstTags;
    private JPanel panel1;
    private JScrollPane spInstructions;
    private JTextArea txtarAddInstructions;
    private JPanel panel3;
    private JScrollPane scrollPane1;
    private JTable tblRelatedRecipes;
    private JButton button1;
    private JButton btnAddRecipe;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

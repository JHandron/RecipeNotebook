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
        final String[] ingredients = parseCommaSeparatedTxtString(txtAddIngredients.getText(), ",");
        for (final String ingredient : ingredients) {
            lstMdlIngredients.addElement(ingredient);
        }
        txtAddIngredients.setText("");
        updateIngredientsList();
    }

    private void txtAddTagsEntered(ActionEvent e) {
        final String[] tags = parseCommaSeparatedTxtString(txtAddTags.getText(), ",");
        for (final String tag : tags) {
            lstMdlTags.addElement(tag);
        }
        txtAddTags.setText("");
        updateTagsList();
    }

    //TODO: Should this exist here?
    private String[] parseCommaSeparatedTxtString(final String p_txtString, final String p_delimiter) {
        final String[] tokens = p_txtString.split(p_delimiter);
        final String[] trimmedTokens = new String[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            trimmedTokens[i] = tokens[i].trim();
        }
        return trimmedTokens;
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
        pnlMain = new JPanel();
        pnlAddNew = new JPanel();
        panel5 = new JPanel();
        txtAddRecipeName = new JTextField();
        lblRecipeName = new JLabel();
        panel11 = new JPanel();
        panel9 = new JPanel();
        label1 = new JLabel();
        txtAddIngredients = new JTextField();
        spIngredients = new JScrollPane();
        lstIngredients = new JList<>();
        panel10 = new JPanel();
        spTags = new JScrollPane();
        lstTags = new JList<>();
        label2 = new JLabel();
        txtAddTags = new JTextField();
        pnlBottom = new JPanel();
        panel4 = new JPanel();
        label3 = new JLabel();
        spInstructions = new JScrollPane();
        txtarAddInstructions = new JTextArea();
        panel2 = new JPanel();
        scrollPane1 = new JScrollPane();
        tblRelatedRecipes = new JTable();
        panel3 = new JPanel();
        button1 = new JButton();
        panel6 = new JPanel();
        btnAddRecipe = new JButton();

        //======== this ========
        setTitle("Jason's Recipe Notebook");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon("C:\\Users\\Jason\\Documents\\Projects\\RecipeNotebook\\src\\onkoyybdqdc81.png").getImage());
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== pnlMain ========
        {
            pnlMain.setMinimumSize(new Dimension(0, 0));
            pnlMain.setLayout(new BorderLayout());

            //======== pnlAddNew ========
            {
                pnlAddNew.setLayout(new BoxLayout(pnlAddNew, BoxLayout.Y_AXIS));

                //======== panel5 ========
                {

                    //---- lblRecipeName ----
                    lblRecipeName.setText("Recipe Name");

                    GroupLayout panel5Layout = new GroupLayout(panel5);
                    panel5.setLayout(panel5Layout);
                    panel5Layout.setHorizontalGroup(
                        panel5Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel5Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblRecipeName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtAddRecipeName))
                                .addContainerGap())
                    );
                    panel5Layout.setVerticalGroup(
                        panel5Layout.createParallelGroup()
                            .addGroup(panel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblRecipeName)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtAddRecipeName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                    );
                }
                pnlAddNew.add(panel5);

                //======== panel11 ========
                {
                    panel11.setLayout(new BoxLayout(panel11, BoxLayout.X_AXIS));

                    //======== panel9 ========
                    {

                        //---- label1 ----
                        label1.setText("Ingredient(s)");

                        //---- txtAddIngredients ----
                        txtAddIngredients.setToolTipText("Press Enter to add an ingredient");
                        txtAddIngredients.addActionListener(e -> txtAddIngredientsEnter(e));

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

                        GroupLayout panel9Layout = new GroupLayout(panel9);
                        panel9.setLayout(panel9Layout);
                        panel9Layout.setHorizontalGroup(
                            panel9Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel9Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel9Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtAddIngredients)
                                        .addComponent(label1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(spIngredients))
                                    .addContainerGap())
                        );
                        panel9Layout.setVerticalGroup(
                            panel9Layout.createParallelGroup()
                                .addGroup(panel9Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(label1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtAddIngredients, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(spIngredients, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
                        );
                    }
                    panel11.add(panel9);

                    //======== panel10 ========
                    {

                        //======== spTags ========
                        {
                            spTags.setViewportView(lstTags);
                        }

                        //---- label2 ----
                        label2.setText("Tag(s)");

                        //---- txtAddTags ----
                        txtAddTags.setToolTipText("Press Enter to add a tag");
                        txtAddTags.addActionListener(e -> txtAddTagsEntered(e));

                        GroupLayout panel10Layout = new GroupLayout(panel10);
                        panel10.setLayout(panel10Layout);
                        panel10Layout.setHorizontalGroup(
                            panel10Layout.createParallelGroup()
                                .addGroup(panel10Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel10Layout.createParallelGroup()
                                        .addComponent(txtAddTags)
                                        .addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(spTags, GroupLayout.Alignment.TRAILING))
                                    .addContainerGap())
                        );
                        panel10Layout.setVerticalGroup(
                            panel10Layout.createParallelGroup()
                                .addGroup(panel10Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(label2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtAddTags, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(spTags, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
                        );
                    }
                    panel11.add(panel10);
                }
                pnlAddNew.add(panel11);

                //======== pnlBottom ========
                {
                    pnlBottom.setLayout(new BoxLayout(pnlBottom, BoxLayout.X_AXIS));

                    //======== panel4 ========
                    {

                        //---- label3 ----
                        label3.setText("Instructions");

                        //======== spInstructions ========
                        {

                            //---- txtarAddInstructions ----
                            txtarAddInstructions.setLineWrap(true);
                            txtarAddInstructions.setWrapStyleWord(true);
                            txtarAddInstructions.setMinimumSize(null);
                            txtarAddInstructions.setPreferredSize(new Dimension(400, 20));
                            txtarAddInstructions.setRequestFocusEnabled(false);
                            spInstructions.setViewportView(txtarAddInstructions);
                        }

                        GroupLayout panel4Layout = new GroupLayout(panel4);
                        panel4.setLayout(panel4Layout);
                        panel4Layout.setHorizontalGroup(
                            panel4Layout.createParallelGroup()
                                .addGroup(GroupLayout.Alignment.TRAILING, panel4Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(panel4Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
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
                                    .addComponent(spInstructions, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
                        );
                    }
                    pnlBottom.add(panel4);

                    //======== panel2 ========
                    {
                        panel2.setBorder(new TitledBorder("Related Recipes"));
                        panel2.setPreferredSize(new Dimension(100, 100));
                        panel2.setLayout(new BorderLayout());

                        //======== scrollPane1 ========
                        {
                            scrollPane1.setPreferredSize(null);

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
                        panel2.add(scrollPane1, BorderLayout.CENTER);

                        //======== panel3 ========
                        {
                            panel3.setLayout(new FlowLayout());

                            //---- button1 ----
                            button1.setText("Search...");
                            button1.addActionListener(e -> spawnSearchDialog(e));
                            panel3.add(button1);
                        }
                        panel2.add(panel3, BorderLayout.SOUTH);
                    }
                    pnlBottom.add(panel2);
                }
                pnlAddNew.add(pnlBottom);

                //======== panel6 ========
                {
                    panel6.setLayout(new FlowLayout());

                    //---- btnAddRecipe ----
                    btnAddRecipe.setText("Add Recipe");
                    btnAddRecipe.addActionListener(e -> addNewRecipe(e));
                    panel6.add(btnAddRecipe);
                }
                pnlAddNew.add(panel6);
            }
            pnlMain.add(pnlAddNew, BorderLayout.CENTER);
        }
        contentPane.add(pnlMain, BorderLayout.CENTER);
        setSize(580, 520);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
    private JPanel pnlMain;
    private JPanel pnlAddNew;
    private JPanel panel5;
    private JTextField txtAddRecipeName;
    private JLabel lblRecipeName;
    private JPanel panel11;
    private JPanel panel9;
    private JLabel label1;
    private JTextField txtAddIngredients;
    private JScrollPane spIngredients;
    private JList<String> lstIngredients;
    private JPanel panel10;
    private JScrollPane spTags;
    private JList<String> lstTags;
    private JLabel label2;
    private JTextField txtAddTags;
    private JPanel pnlBottom;
    private JPanel panel4;
    private JLabel label3;
    private JScrollPane spInstructions;
    private JTextArea txtarAddInstructions;
    private JPanel panel2;
    private JScrollPane scrollPane1;
    private JTable tblRelatedRecipes;
    private JPanel panel3;
    private JButton button1;
    private JPanel panel6;
    private JButton btnAddRecipe;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

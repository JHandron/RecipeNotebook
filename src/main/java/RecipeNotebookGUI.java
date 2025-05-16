import org.bson.Document;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * @author Jason
 */

public class RecipeNotebookGUI extends JFrame {

    //TODO:Here?
    private final static DefaultListModel<String> listModelIngredients = new DefaultListModel<>();
    private final static DefaultListModel<String> listModelTags = new DefaultListModel<>();
    private final static DefaultTableModel tableModelSearch = new DefaultTableModel();

    public RecipeNotebookGUI() {
        initComponents();
        init();
    }

    public void init(){
        tableModelSearch.setColumnIdentifiers(new Object[]{"Name", "Tags"});
        tblSearchResults.setModel(tableModelSearch);
    }
    
    private void addNewRecipe(ActionEvent e) {
        final Recipe recipe = new Recipe();
        recipe.setName(txtAddRecipeName.getText().trim()); //TODO:Better input sanitization
        recipe.setInstructions(txtarAddInstructions.getText().trim());

        for (Object o : listModelTags.toArray()){
            recipe.getTagsList().add((String)o);
        }

        for (Object o : listModelIngredients.toArray()){
            recipe.getIngredientList().add((String)o);
        }
        MongoDelegator.doInsert(recipe);
    }

    private void updateIngredientsList(){
        lstIngredients.setModel(listModelIngredients);
    }

    private void updateTagsList(){
        lstTags.setModel(listModelTags);
    }

    private void rbNameSelected(ActionEvent e) {
        CardLayout layout = (CardLayout) pnlSearchInput.getLayout();
        layout.show(pnlSearchInput, "nameSearchCard");
    }

    private void rbInstructionsSelected(ActionEvent e) {
        CardLayout layout = (CardLayout) pnlSearchInput.getLayout();
        layout.show(pnlSearchInput, "descriptionSearchCard");
    }

    private void rbIngredientsSelected(ActionEvent e) {
        CardLayout layout = (CardLayout) pnlSearchInput.getLayout();
        layout.show(pnlSearchInput, "ingredientSearchCard");
    }

    private void rbTagsSelected(ActionEvent e) {
        CardLayout layout = (CardLayout) pnlSearchInput.getLayout();
        layout.show(pnlSearchInput, "tagsSearchCard");
    }

    private void doFind(ActionEvent e) {
        if (rbName.isSelected()){
            List<Document> results = MongoDelegator.getBulkByName(txtSearchName.getText().trim());
            if (!results.isEmpty()) {
                updateSearchTable(results);
            }
        }
        else if (rbInstructions.isSelected()){
            //do Search
        }
        else if (rbIngredients.isSelected()){
            MongoDelegator.getByInstructions(txtSearchName.getText().trim());
        }
        else if (rbTags.isSelected()){
            MongoDelegator.getByTags(List.of(txtSearchName.getText().split(", ")));//TODO: Adjust split value to account for whitespace or not
        }
    }

    private void updateSearchTable(List<Document> p_results) {
        for (Document doc : p_results) {
            Object tags = doc.get("tagsList");
            String tagsString = "";

            if (tags instanceof List) {
                tagsString = ((List<?>) tags).stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(", "));
            }
            if (tagsString.isEmpty()){
                tagsString = "(No tags entered)";
            }

            final Object[] rowData = {doc.get("name"), tagsString};
            tableModelSearch.addRow(rowData);
        }
        tblSearchResults.setModel(tableModelSearch);
    }

    private void txtAddIngredientsEnter(ActionEvent e) {
        listModelIngredients.addElement(txtAddIngredients.getText().trim());
        txtAddIngredients.setText("");
        updateIngredientsList();
    }

    private void txtAddTagsEntered(ActionEvent e) {
        listModelTags.addElement(txtAddTags.getText().trim());
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
                listModelIngredients.remove(selectedIndex);
                updateIngredientsList();
            }
        });
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        tabbedPane1 = new JTabbedPane();
        pnlAddNew = new JPanel();
        lblRecipeName = new JLabel();
        txtAddRecipeName = new JTextField();
        txtAddIngredients = new JTextField();
        spIngredients = new JScrollPane();
        lstIngredients = new JList<>();
        txtAddTags = new JTextField();
        spTags = new JScrollPane();
        lstTags = new JList<>();
        spInstructions = new JScrollPane();
        txtarAddInstructions = new JTextArea();
        btnAddRecipe = new JButton();
        pnlFindRecipe = new JPanel();
        pnlSearchBy = new JPanel();
        rbName = new JRadioButton();
        rbInstructions = new JRadioButton();
        rbIngredients = new JRadioButton();
        rbTags = new JRadioButton();
        pnlSearchInput = new JPanel();
        pnlNameSearch = new JPanel();
        txtSearchName = new JTextField();
        btnFind = new JButton();
        scrInstructionsSearch = new JScrollPane();
        txtarSearchInstructions = new JTextArea();
        scrSearchResults = new JScrollPane();
        tblSearchResults = new JTable();

        //======== this ========
        setTitle("Jason's Recipe Notebook");
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

                //---- menuItem2 ----
                menuItem2.setText("Exit");
                menu1.add(menuItem2);
                menu1.addSeparator();
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
                ((GridBagLayout)pnlAddNew.getLayout()).columnWidths = new int[] {302, 260, 0};
                ((GridBagLayout)pnlAddNew.getLayout()).rowHeights = new int[] {51, 10, 88, 6, 90, 172, 56, 0};
                ((GridBagLayout)pnlAddNew.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
                ((GridBagLayout)pnlAddNew.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 1.0E-4};

                //---- lblRecipeName ----
                lblRecipeName.setText("Recipe Name");
                pnlAddNew.add(lblRecipeName, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.WEST, GridBagConstraints.NONE,
                    new Insets(0, 25, 0, 0), 0, 0));
                pnlAddNew.add(txtAddRecipeName, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(5, 110, 5, 25), 0, 0));

                //---- txtAddIngredients ----
                txtAddIngredients.setToolTipText("Type ingredients and press Enter");
                txtAddIngredients.addActionListener(e -> txtAddIngredientsEnter(e));
                pnlAddNew.add(txtAddIngredients, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(5, 10, 5, 10), 0, 0));

                //======== spIngredients ========
                {
                    spIngredients.setViewportBorder(new TitledBorder("Ingredients"));

                    //---- lstIngredients ----
                    lstIngredients.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            lstIngredientsMouseClicked(e);
                        }
                    });
                    spIngredients.setViewportView(lstIngredients);
                }
                pnlAddNew.add(spIngredients, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 10), 0, 0));

                //---- txtAddTags ----
                txtAddTags.setToolTipText("Type tags and press Enter");
                txtAddTags.addActionListener(e -> txtAddTagsEntered(e));
                pnlAddNew.add(txtAddTags, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                    new Insets(5, 10, 5, 10), 0, 0));

                //======== spTags ========
                {
                    spTags.setViewportBorder(new TitledBorder("Tags"));
                    spTags.setViewportView(lstTags);
                }
                pnlAddNew.add(spTags, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 10), 0, 0));

                //======== spInstructions ========
                {
                    spInstructions.setViewportBorder(new TitledBorder("Instructions"));
                    spInstructions.setViewportView(txtarAddInstructions);
                }
                pnlAddNew.add(spInstructions, new GridBagConstraints(0, 5, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(10, 10, 10, 10), 0, 0));

                //---- btnAddRecipe ----
                btnAddRecipe.setText("Add Recipe");
                btnAddRecipe.addActionListener(e -> addNewRecipe(e));
                pnlAddNew.add(btnAddRecipe, new GridBagConstraints(0, 6, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.NONE,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            tabbedPane1.addTab("Add New Recipe", pnlAddNew);

            //======== pnlFindRecipe ========
            {
                pnlFindRecipe.setLayout(new GridBagLayout());
                ((GridBagLayout)pnlFindRecipe.getLayout()).columnWidths = new int[] {315, 0};
                ((GridBagLayout)pnlFindRecipe.getLayout()).rowHeights = new int[] {75, 75, 347, 0};
                ((GridBagLayout)pnlFindRecipe.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                ((GridBagLayout)pnlFindRecipe.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0, 1.0E-4};

                //======== pnlSearchBy ========
                {
                    pnlSearchBy.setBorder(new TitledBorder("Search By"));
                    pnlSearchBy.setLayout(new GridLayout(1, 1, 5, 5));

                    //---- rbName ----
                    rbName.setText("Name");
                    rbName.setHorizontalAlignment(SwingConstants.CENTER);
                    rbName.setSelected(true);
                    rbName.addActionListener(e -> rbNameSelected(e));
                    pnlSearchBy.add(rbName);

                    //---- rbInstructions ----
                    rbInstructions.setText("Instructions");
                    rbInstructions.setHorizontalAlignment(SwingConstants.CENTER);
                    rbInstructions.setEnabled(false);
                    rbInstructions.addActionListener(e -> rbInstructionsSelected(e));
                    pnlSearchBy.add(rbInstructions);

                    //---- rbIngredients ----
                    rbIngredients.setText("Ingredients");
                    rbIngredients.setHorizontalAlignment(SwingConstants.CENTER);
                    rbIngredients.addActionListener(e -> rbIngredientsSelected(e));
                    pnlSearchBy.add(rbIngredients);

                    //---- rbTags ----
                    rbTags.setText("Tags");
                    rbTags.setHorizontalAlignment(SwingConstants.CENTER);
                    rbTags.addActionListener(e -> rbTagsSelected(e));
                    pnlSearchBy.add(rbTags);
                }
                pnlFindRecipe.add(pnlSearchBy, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(5, 5, 5, 5), 0, 0));

                //======== pnlSearchInput ========
                {
                    pnlSearchInput.setLayout(new CardLayout());

                    //======== pnlNameSearch ========
                    {
                        pnlNameSearch.setLayout(new GridBagLayout());
                        ((GridBagLayout)pnlNameSearch.getLayout()).columnWidths = new int[] {376, 110, 0};
                        ((GridBagLayout)pnlNameSearch.getLayout()).rowHeights = new int[] {0, 0};
                        ((GridBagLayout)pnlNameSearch.getLayout()).columnWeights = new double[] {1.0, 0.0, 1.0E-4};
                        ((GridBagLayout)pnlNameSearch.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};
                        pnlNameSearch.add(txtSearchName, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                            new Insets(10, 10, 10, 10), 0, 0));

                        //---- btnFind ----
                        btnFind.setText("Find");
                        btnFind.addActionListener(e -> doFind(e));
                        pnlNameSearch.add(btnFind, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.NONE,
                            new Insets(0, 0, 0, 0), 0, 0));
                    }
                    pnlSearchInput.add(pnlNameSearch, "txtSearchCard");

                    //======== scrInstructionsSearch ========
                    {
                        scrInstructionsSearch.setViewportView(txtarSearchInstructions);
                    }
                    pnlSearchInput.add(scrInstructionsSearch, "descriptionSearchCard");
                }
                pnlFindRecipe.add(pnlSearchInput, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));

                //======== scrSearchResults ========
                {

                    //---- tblSearchResults ----
                    tblSearchResults.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            null, null
                        }
                    ) {
                        boolean[] columnEditable = new boolean[] {
                            false, true
                        };
                        @Override
                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                            return columnEditable[columnIndex];
                        }
                    });
                    scrSearchResults.setViewportView(tblSearchResults);
                }
                pnlFindRecipe.add(scrSearchResults, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(10, 10, 10, 10), 0, 0));
            }
            tabbedPane1.addTab("Search Recipes", pnlFindRecipe);
        }
        contentPane.add(tabbedPane1, BorderLayout.CENTER);
        setSize(555, 500);
        setLocationRelativeTo(null);

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(rbName);
        buttonGroup1.add(rbInstructions);
        buttonGroup1.add(rbIngredients);
        buttonGroup1.add(rbTags);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JTabbedPane tabbedPane1;
    private JPanel pnlAddNew;
    private JLabel lblRecipeName;
    private JTextField txtAddRecipeName;
    private JTextField txtAddIngredients;
    private JScrollPane spIngredients;
    private JList<String> lstIngredients;
    private JTextField txtAddTags;
    private JScrollPane spTags;
    private JList<String> lstTags;
    private JScrollPane spInstructions;
    private JTextArea txtarAddInstructions;
    private JButton btnAddRecipe;
    private JPanel pnlFindRecipe;
    private JPanel pnlSearchBy;
    private JRadioButton rbName;
    private JRadioButton rbInstructions;
    private JRadioButton rbIngredients;
    private JRadioButton rbTags;
    private JPanel pnlSearchInput;
    private JPanel pnlNameSearch;
    private JTextField txtSearchName;
    private JButton btnFind;
    private JScrollPane scrInstructionsSearch;
    private JTextArea txtarSearchInstructions;
    private JScrollPane scrSearchResults;
    private JTable tblSearchResults;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

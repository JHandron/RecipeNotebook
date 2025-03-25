import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Fri Feb 21 17:53:54 EST 2025
 */

/**
 * @author Jason
 */

public class RecipeNotebookGUI extends JTabbedPane {

    public RecipeNotebookGUI() {
        initComponents();
    }

    public JPanel getPnlAddNew() {
        return pnlAddNew;
    }

    public JLabel getLblRecipeName() {
        return lblRecipeName;
    }

    public JTextField getTxtAddRecipeName() {
        return txtAddRecipeName;
    }

    public JScrollPane getSpInstructions() {
        return spInstructions;
    }

    public JTextArea getTxtarAddInstructions() {
        return txtarAddInstructions;
    }

    public JTextField getTxtAddIngredients() {
        return txtAddIngredients;
    }

    public JScrollPane getSpIngredients() {
        return spIngredients;
    }

    public JList<String> getLstIngredients() {
        return lstIngredients;
    }

    public JTextField getTxtAddTags() {
        return txtAddTags;
    }

    public JScrollPane getSpTags() {
        return spTags;
    }

    public JList<String> getLstTags() {
        return lstTags;
    }

    public JButton getBtnAddRecipe() {
        return btnAddRecipe;
    }

    public JPanel getPnlFindRecipe() {
        return pnlFindRecipe;
    }

    public JPanel getPnlSearchBy() {
        return pnlSearchBy;
    }

    public JRadioButton getRbName() {
        return rbName;
    }

    public JRadioButton getRbInstructions() {
        return rbInstructions;
    }

    public JRadioButton getRbIngredients() {
        return rbIngredients;
    }

    public JRadioButton getRbTags() {
        return rbTags;
    }

    public JPanel getPnlSearchInput() {
        return pnlSearchInput;
    }

    public JPanel getPnlNameSearch() {
        return pnlNameSearch;
    }

    public JTextField getTxtSearchName() {
        return txtSearchName;
    }

    public JScrollPane getScrpnInstructionsSearch() {
        return scrpnInstructionsSearch;
    }

    public JTextArea getTxtarSearchInstructions() {
        return txtarSearchInstructions;
    }

    public JPanel getPnlTagsSearch() {
        return pnlTagsSearch;
    }

    public JTextField getTxtSearchTags() {
        return txtSearchTags;
    }

    public JButton getBtnFind() {
        return btnFind;
    }

    public JPanel getPnlIngredientSearch() {
        return pnlIngredientSearch;
    }

    public JTextField getTxtSearchIngredients() {
        return txtSearchIngredients;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
        pnlAddNew = new JPanel();
        lblRecipeName = new JLabel();
        txtAddRecipeName = new JTextField();
        txtAddIngredients = new JTextField();
        spIngredients = new JScrollPane();
        lstIngredients = new JList<>();
        spInstructions = new JScrollPane();
        txtarAddInstructions = new JTextArea();
        txtAddTags = new JTextField();
        spTags = new JScrollPane();
        lstTags = new JList<>();
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
        scrpnInstructionsSearch = new JScrollPane();
        txtarSearchInstructions = new JTextArea();
        pnlIngredientSearch = new JPanel();
        txtSearchIngredients = new JTextField();
        pnlTagsSearch = new JPanel();
        txtSearchTags = new JTextField();
        btnFind = new JButton();

        //======== this ========

        //======== pnlAddNew ========
        {
            pnlAddNew.setLayout(new GridBagLayout());
            ((GridBagLayout)pnlAddNew.getLayout()).columnWidths = new int[] {395, 337, 0};
            ((GridBagLayout)pnlAddNew.getLayout()).rowHeights = new int[] {51, 10, 110, 124, 8, 7, 118, 56, 0};
            ((GridBagLayout)pnlAddNew.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0E-4};
            ((GridBagLayout)pnlAddNew.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0E-4};

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
            pnlAddNew.add(txtAddIngredients, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 10, 5, 5), 0, 0));

            //======== spIngredients ========
            {
                spIngredients.setViewportBorder(new TitledBorder("Ingredients"));
                spIngredients.setViewportView(lstIngredients);
            }
            pnlAddNew.add(spIngredients, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 10), 0, 0));

            //======== spInstructions ========
            {
                spInstructions.setViewportBorder(new TitledBorder("Instructions"));
                spInstructions.setViewportView(txtarAddInstructions);
            }
            pnlAddNew.add(spInstructions, new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(10, 10, 10, 10), 0, 0));

            //---- txtAddTags ----
            txtAddTags.setToolTipText("Type tags and press Enter");
            pnlAddNew.add(txtAddTags, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 10, 5, 5), 0, 0));

            //======== spTags ========
            {
                spTags.setViewportBorder(new TitledBorder("Tags"));
                spTags.setViewportView(lstTags);
            }
            pnlAddNew.add(spTags, new GridBagConstraints(1, 6, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 10), 0, 0));

            //---- btnAddRecipe ----
            btnAddRecipe.setText("Add Recipe");
            pnlAddNew.add(btnAddRecipe, new GridBagConstraints(0, 7, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        addTab("Add New Recipe", pnlAddNew);

        //======== pnlFindRecipe ========
        {
            pnlFindRecipe.setLayout(new GridBagLayout());
            ((GridBagLayout)pnlFindRecipe.getLayout()).columnWidths = new int[] {315, 142, 0};
            ((GridBagLayout)pnlFindRecipe.getLayout()).rowHeights = new int[] {56, 269, 52, 56, 0};
            ((GridBagLayout)pnlFindRecipe.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
            ((GridBagLayout)pnlFindRecipe.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0, 1.0, 1.0E-4};

            //======== pnlSearchBy ========
            {
                pnlSearchBy.setBorder(new TitledBorder("Search By"));
                pnlSearchBy.setLayout(new GridLayout(1, 1, 5, 5));

                //---- rbName ----
                rbName.setText("Name");
                rbName.setHorizontalAlignment(SwingConstants.CENTER);
                rbName.setSelected(true);
                pnlSearchBy.add(rbName);

                //---- rbInstructions ----
                rbInstructions.setText("Instructions");
                rbInstructions.setHorizontalAlignment(SwingConstants.CENTER);
                pnlSearchBy.add(rbInstructions);

                //---- rbIngredients ----
                rbIngredients.setText("Ingredients");
                rbIngredients.setHorizontalAlignment(SwingConstants.CENTER);
                pnlSearchBy.add(rbIngredients);

                //---- rbTags ----
                rbTags.setText("Tags");
                rbTags.setHorizontalAlignment(SwingConstants.CENTER);
                pnlSearchBy.add(rbTags);
            }
            pnlFindRecipe.add(pnlSearchBy, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //======== pnlSearchInput ========
            {
                pnlSearchInput.setLayout(new CardLayout());

                //======== pnlNameSearch ========
                {
                    pnlNameSearch.setLayout(new GridBagLayout());
                    ((GridBagLayout)pnlNameSearch.getLayout()).columnWidths = new int[] {0, 0};
                    ((GridBagLayout)pnlNameSearch.getLayout()).rowHeights = new int[] {0, 0};
                    ((GridBagLayout)pnlNameSearch.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                    ((GridBagLayout)pnlNameSearch.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};
                    pnlNameSearch.add(txtSearchName, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                pnlSearchInput.add(pnlNameSearch, "nameSearchCard");

                //======== scrpnInstructionsSearch ========
                {
                    scrpnInstructionsSearch.setViewportView(txtarSearchInstructions);
                }
                pnlSearchInput.add(scrpnInstructionsSearch, "descriptionSearchCard");

                //======== pnlIngredientSearch ========
                {
                    pnlIngredientSearch.setLayout(new GridBagLayout());
                    ((GridBagLayout)pnlIngredientSearch.getLayout()).columnWidths = new int[] {0, 0};
                    ((GridBagLayout)pnlIngredientSearch.getLayout()).rowHeights = new int[] {0, 0};
                    ((GridBagLayout)pnlIngredientSearch.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                    ((GridBagLayout)pnlIngredientSearch.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};
                    pnlIngredientSearch.add(txtSearchIngredients, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                pnlSearchInput.add(pnlIngredientSearch, "ingredientSearchCard");

                //======== pnlTagsSearch ========
                {
                    pnlTagsSearch.setLayout(new GridBagLayout());
                    ((GridBagLayout)pnlTagsSearch.getLayout()).columnWidths = new int[] {318, 0};
                    ((GridBagLayout)pnlTagsSearch.getLayout()).rowHeights = new int[] {0, 0};
                    ((GridBagLayout)pnlTagsSearch.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                    ((GridBagLayout)pnlTagsSearch.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};
                    pnlTagsSearch.add(txtSearchTags, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                pnlSearchInput.add(pnlTagsSearch, "tagsSearchCard");
            }
            pnlFindRecipe.add(pnlSearchInput, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- btnFind ----
            btnFind.setText("Find");
            pnlFindRecipe.add(btnFind, new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        addTab("Search Recipes", pnlFindRecipe);

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
    private JPanel pnlAddNew;
    private JLabel lblRecipeName;
    private JTextField txtAddRecipeName;
    private JTextField txtAddIngredients;
    private JScrollPane spIngredients;
    private JList<String> lstIngredients;
    private JScrollPane spInstructions;
    private JTextArea txtarAddInstructions;
    private JTextField txtAddTags;
    private JScrollPane spTags;
    private JList<String> lstTags;
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
    private JScrollPane scrpnInstructionsSearch;
    private JTextArea txtarSearchInstructions;
    private JPanel pnlIngredientSearch;
    private JTextField txtSearchIngredients;
    private JPanel pnlTagsSearch;
    private JTextField txtSearchTags;
    private JButton btnFind;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

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

    public JTextField getTxtRecipeName() {
        return txtRecipeName;
    }

    public JScrollPane getSpInstructions() {
        return spInstructions;
    }

    public JTextArea getTxtaInstructions() {
        return txtaInstructions;
    }

    public JTextField getTxtIngredients() {
        return txtIngredients;
    }

    public JScrollPane getSpIngredients() {
        return spIngredients;
    }

    public JList<String> getLstIngredients() {
        return lstIngredients;
    }

    public JTextField getTxtTags() {
        return txtTags;
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

    public JTextField getTxtNameSearch() {
        return txtNameSearch;
    }

    public JScrollPane getScrpnInstructionsSearch() {
        return scrpnInstructionsSearch;
    }

    public JTextArea getTxtInstructionsSearch() {
        return txtInstructionsSearch;
    }

    public JScrollPane getScrpnIngredientsSearch() {
        return scrpnIngredientsSearch;
    }

    public JList getLstIngredientsSearch() {
        return lstIngredientsSearch;
    }

    public JPanel getPnlTagsSearch() {
        return pnlTagsSearch;
    }

    public JTextField getTxtTagsSearch() {
        return txtTagsSearch;
    }

    public JButton getBtnFind() {
        return btnFind;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
        pnlAddNew = new JPanel();
        lblRecipeName = new JLabel();
        txtRecipeName = new JTextField();
        txtIngredients = new JTextField();
        spIngredients = new JScrollPane();
        lstIngredients = new JList<>();
        spInstructions = new JScrollPane();
        txtaInstructions = new JTextArea();
        txtTags = new JTextField();
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
        txtNameSearch = new JTextField();
        scrpnInstructionsSearch = new JScrollPane();
        txtInstructionsSearch = new JTextArea();
        scrpnIngredientsSearch = new JScrollPane();
        lstIngredientsSearch = new JList();
        pnlTagsSearch = new JPanel();
        txtTagsSearch = new JTextField();
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
            pnlAddNew.add(txtRecipeName, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(5, 110, 5, 25), 0, 0));

            //---- txtIngredients ----
            txtIngredients.setToolTipText("Type ingredients and press Enter");
            pnlAddNew.add(txtIngredients, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
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
                spInstructions.setViewportView(txtaInstructions);
            }
            pnlAddNew.add(spInstructions, new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(10, 10, 10, 10), 0, 0));

            //---- txtTags ----
            txtTags.setToolTipText("Type tags and press Enter");
            pnlAddNew.add(txtTags, new GridBagConstraints(0, 6, 1, 1, 0.0, 0.0,
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
                    pnlNameSearch.setBorder(new EmptyBorder(60, 50, 60, 50));
                    pnlNameSearch.setLayout(new GridBagLayout());
                    ((GridBagLayout)pnlNameSearch.getLayout()).columnWidths = new int[] {0, 0};
                    ((GridBagLayout)pnlNameSearch.getLayout()).rowHeights = new int[] {0, 0};
                    ((GridBagLayout)pnlNameSearch.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                    ((GridBagLayout)pnlNameSearch.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};
                    pnlNameSearch.add(txtNameSearch, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                pnlSearchInput.add(pnlNameSearch, "nameSearchCard");

                //======== scrpnInstructionsSearch ========
                {
                    scrpnInstructionsSearch.setViewportView(txtInstructionsSearch);
                }
                pnlSearchInput.add(scrpnInstructionsSearch, "descriptionSearchCard");

                //======== scrpnIngredientsSearch ========
                {
                    scrpnIngredientsSearch.setViewportView(lstIngredientsSearch);
                }
                pnlSearchInput.add(scrpnIngredientsSearch, "ingredientSearchCard");

                //======== pnlTagsSearch ========
                {
                    pnlTagsSearch.setLayout(new BorderLayout());
                    pnlTagsSearch.add(txtTagsSearch, BorderLayout.CENTER);
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
    private JTextField txtRecipeName;
    private JTextField txtIngredients;
    private JScrollPane spIngredients;
    private JList<String> lstIngredients;
    private JScrollPane spInstructions;
    private JTextArea txtaInstructions;
    private JTextField txtTags;
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
    private JTextField txtNameSearch;
    private JScrollPane scrpnInstructionsSearch;
    private JTextArea txtInstructionsSearch;
    private JScrollPane scrpnIngredientsSearch;
    private JList lstIngredientsSearch;
    private JPanel pnlTagsSearch;
    private JTextField txtTagsSearch;
    private JButton btnFind;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

/*
 * Created by JFormDesigner on Wed May 28 20:08:40 EDT 2025
 */

package org.jhandron;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * @author Jason
 */
public class SearchDialog extends JDialog {

    private final RecipeTableModel tblMdlSearchResults = new RecipeTableModel();

    //TODO:Probably a way to JFD this
    private RecipeSelectionListener selectionListener;
    public void setRecipeSelectionListener(RecipeSelectionListener listener) {
        this.selectionListener = listener;
    }

    public SearchDialog(Window owner, RecipeSelectionListener recipeSelectionListener) {
        super(owner);
        this.selectionListener = recipeSelectionListener;
        initComponents();
        init();
    }

    public void init(){
        tblMdlSearchResults.clearModel();
        tblSearchResults.setModel(tblMdlSearchResults);
        hideColumns();
    }

    private void hideColumns() {
        tblSearchResults.removeColumn(tblSearchResults.getColumnModel().getColumn(0)); //ID
    }

    private void doFind(ActionEvent e) {
        if (rbName.isSelected()){
            Collection<Recipe> recipeSearchResults = MongoDelegator.getCollectionByName(txtSearchName.getText().trim());
            if (!recipeSearchResults.isEmpty()) {
                updateSearchTable((List<Recipe>) recipeSearchResults);
            }
        }
        else if (rbIngredients.isSelected()){
            MongoDelegator.getByInstructions(txtSearchName.getText().trim());
        }
        else if (rbTags.isSelected()){
            MongoDelegator.getByTags(List.of(txtSearchName.getText().split(", ")));//TODO: Adjust split value to account for whitespace or not
        }
    }

    private void updateSearchTable(List<Recipe> p_results) {
        tblMdlSearchResults.clearModel(); //clear prior results
        for (Recipe recipe : p_results){
            tblMdlSearchResults.addRecipe(recipe);
        }
    }

    private void selectRecipe(ActionEvent e) {
        int[] selectedRowIndexes = tblSearchResults.getSelectedRows();
        List<Recipe> selectedRecipes = new ArrayList<>();
        for (int i : selectedRowIndexes) {
            selectedRecipes.add(tblMdlSearchResults.getRecipeAt(i));
        }
        selectionListener.onRecipesSelected(selectedRecipes); // 🔥 Fire the callback
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
        pnlSearch = new JPanel();
        pnlSearchBy = new JPanel();
        rbName = new JRadioButton();
        rbIngredients = new JRadioButton();
        rbTags = new JRadioButton();
        pnlSearchInput = new JPanel();
        pnlNameSearch = new JPanel();
        txtSearchName = new JTextField();
        btnFind = new JButton();
        scrInstructionsSearch = new JScrollPane();
        txtarSearchInstructions = new JTextArea();
        pnlSearchResults = new JPanel();
        scrSearchResults = new JScrollPane();
        tblSearchResults = new JTable();
        button1 = new JButton();

        //======== this ========
        setTitle("Search");
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        var contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {352, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {1.0, 1.0, 1.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

        //======== pnlSearch ========
        {
            pnlSearch.setLayout(new GridBagLayout());
            ((GridBagLayout)pnlSearch.getLayout()).columnWidths = new int[] {315, 0};
            ((GridBagLayout)pnlSearch.getLayout()).rowHeights = new int[] {62, 56, 226, 0};
            ((GridBagLayout)pnlSearch.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
            ((GridBagLayout)pnlSearch.getLayout()).rowWeights = new double[] {1.0, 1.0, 1.0, 1.0E-4};

            //======== pnlSearchBy ========
            {
                pnlSearchBy.setBorder(new TitledBorder("Search By"));
                pnlSearchBy.setLayout(new GridLayout(1, 1, 5, 5));

                //---- rbName ----
                rbName.setText("Name");
                rbName.setHorizontalAlignment(SwingConstants.CENTER);
                rbName.setSelected(true);
                pnlSearchBy.add(rbName);

                //---- rbIngredients ----
                rbIngredients.setText("Ingredients");
                rbIngredients.setHorizontalAlignment(SwingConstants.CENTER);
                pnlSearchBy.add(rbIngredients);

                //---- rbTags ----
                rbTags.setText("Tags");
                rbTags.setHorizontalAlignment(SwingConstants.CENTER);
                pnlSearchBy.add(rbTags);
            }
            pnlSearch.add(pnlSearchBy, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
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
                    btnFind.addActionListener(e -> {
			doFind(e);
			doFind(e);
		});
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
            pnlSearch.add(pnlSearchInput, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //======== pnlSearchResults ========
            {
                pnlSearchResults.setBorder(new TitledBorder("Search Results"));
                pnlSearchResults.setLayout(new GridBagLayout());
                ((GridBagLayout)pnlSearchResults.getLayout()).columnWidths = new int[] {157, 96, 152, 0};
                ((GridBagLayout)pnlSearchResults.getLayout()).rowHeights = new int[] {0, 0, 0};
                ((GridBagLayout)pnlSearchResults.getLayout()).columnWeights = new double[] {1.0, 0.0, 1.0, 1.0E-4};
                ((GridBagLayout)pnlSearchResults.getLayout()).rowWeights = new double[] {1.0, 0.0, 1.0E-4};

                //======== scrSearchResults ========
                {

                    //---- tblSearchResults ----
                    tblSearchResults.setModel(new DefaultTableModel(
                        new Object[][] {
                        },
                        new String[] {
                            null, null, null
                        }
                    ));
                    scrSearchResults.setViewportView(tblSearchResults);
                }
                pnlSearchResults.add(scrSearchResults, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- button1 ----
                button1.setText("Select");
                button1.addActionListener(e -> selectRecipe(e));
                pnlSearchResults.add(button1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 0, 5), 0, 0));
            }
            pnlSearch.add(pnlSearchResults, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 5, 5, 5), 0, 0));
        }
        contentPane.add(pnlSearch, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        setSize(415, 375);
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(rbName);
        buttonGroup1.add(rbIngredients);
        buttonGroup1.add(rbTags);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
    private JPanel pnlSearch;
    private JPanel pnlSearchBy;
    private JRadioButton rbName;
    private JRadioButton rbIngredients;
    private JRadioButton rbTags;
    private JPanel pnlSearchInput;
    private JPanel pnlNameSearch;
    private JTextField txtSearchName;
    private JButton btnFind;
    private JScrollPane scrInstructionsSearch;
    private JTextArea txtarSearchInstructions;
    private JPanel pnlSearchResults;
    private JScrollPane scrSearchResults;
    private JTable tblSearchResults;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

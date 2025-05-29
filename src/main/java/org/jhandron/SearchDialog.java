/*
 * Created by JFormDesigner on Wed May 28 20:08:40 EDT 2025
 */

package org.jhandron;

import org.bson.Document;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

/**
 * @author Jason
 */
public class SearchDialog extends JDialog {

    //TODO:Here?
    private final static DefaultTableModel tableModelSearch = new DefaultTableModel();

    public SearchDialog(Window owner) {
        super(owner);
        initComponents();
        init();
        setVisible(true); //TODO: Probably a better way to do this
    }

    public void init(){
        tableModelSearch.setColumnIdentifiers(new Object[]{"Name", "Tags"});
        tblSearchResults.setModel(tableModelSearch);
    }

    private void rbNameSelected(ActionEvent e) {
        // TODO add your code here
    }

    private void rbInstructionsSelected(ActionEvent e) {
        // TODO add your code here
    }

    private void rbIngredientsSelected(ActionEvent e) {
        // TODO add your code here
    }

    private void rbTagsSelected(ActionEvent e) {
        // TODO add your code here
    }

    private void doFind(ActionEvent e) {
        if (rbName.isSelected()){
            java.util.List<Document> results = MongoDelegator.getBulkByName(txtSearchName.getText().trim());
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
        tableModelSearch.setRowCount(0); //clear prior results
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
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
        panel2 = new JPanel();
        scrSearchResults = new JScrollPane();
        tblSearchResults = new JTable();

        //======== this ========
        setTitle("Search");
        setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
        var contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {0, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

        //======== pnlFindRecipe ========
        {
            pnlFindRecipe.setLayout(new GridBagLayout());
            ((GridBagLayout)pnlFindRecipe.getLayout()).columnWidths = new int[] {315, 0};
            ((GridBagLayout)pnlFindRecipe.getLayout()).rowHeights = new int[] {75, 75, 280, 0};
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
            pnlFindRecipe.add(pnlSearchInput, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));

            //======== panel2 ========
            {
                panel2.setBorder(new TitledBorder("Search Results"));
                panel2.setMaximumSize(null);
                panel2.setMinimumSize(null);
                panel2.setLayout(new GridBagLayout());
                ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {315, 0};
                ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {60, 0};
                ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
                ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

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
                    tblSearchResults.setPreferredScrollableViewportSize(null);
                    scrSearchResults.setViewportView(tblSearchResults);
                }
                panel2.add(scrSearchResults, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            pnlFindRecipe.add(panel2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(pnlFindRecipe, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());

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
    private JPanel panel2;
    private JScrollPane scrSearchResults;
    private JTable tblSearchResults;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

/*
 * Created by JFormDesigner on Sun Dec 28 13:50:08 EST 2025
 */

package org.jhandron;

import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.TableModel;

/**
 * @author Jason
 */
public class PnlSearch extends JPanel implements SearchView {

    private final PnlSearchController controller;
    private final RecipeSelectionListener selectionListener;

    public PnlSearch() {
        this(null, null);
    }

    public PnlSearch(RecipeSelectionListener selectionListener, Runnable closeCallback) {
        initComponents();
        this.selectionListener = selectionListener != null ? selectionListener : recipes -> { };
        controller = new PnlSearchController(this, this.selectionListener);
        wireListeners();
        controller.initializeViewBindings();
        hideColumns();
    }

    @Override
    public void bindSearchResultsTableModel(TableModel searchResultsModel) {
        tblSearchResults.setModel(searchResultsModel);
    }

    @Override
    public void closeDialog() {
        // no-op for panel usage; dialog hosting can override/extend later
    }

    private void wireListeners() {
        rbName.setSelected(true);
        btnSearch.addActionListener(this::doSearch);
        btnViewRecipe.addActionListener(this::selectRecipe);
    }

    private void doSearch(ActionEvent e) {
        controller.handleSearch(getSelectedSearchMode(), txtSearch.getText());
    }

    private PnlSearchController.SearchMode getSelectedSearchMode() {
        if (rbIngredients.isSelected()) {
            return PnlSearchController.SearchMode.INGREDIENTS;
        }
        if (rbTags.isSelected()) {
            return PnlSearchController.SearchMode.TAGS;
        }
        return PnlSearchController.SearchMode.NAME;
    }

    private void selectRecipe(ActionEvent e) {
        controller.handleRecipeSelection(tblSearchResults.getSelectedRows());
    }

    private void hideColumns() {
        TableColumnUtils.hideColumns(tblSearchResults, RecipeTableModel.COLUMN_NAMES[0]); // Id
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
        panel1 = new JPanel();
        panel2 = new JPanel();
        lblSearchBy = new JLabel();
        panel7 = new JPanel();
        rbName = new JRadioButton();
        rbIngredients = new JRadioButton();
        rbTags = new JRadioButton();
        panel3 = new JPanel();
        txtSearch = new JTextField();
        btnSearch = new JButton();
        panel4 = new JPanel();
        panel6 = new JPanel();
        scrollPane2 = new JScrollPane();
        tblSearchResults = new JTable();
        lblSearchResults = new JLabel();
        panel5 = new JPanel();
        btnViewRecipe = new JButton();

        //======== this ========
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

            //======== panel2 ========
            {

                //---- lblSearchBy ----
                lblSearchBy.setText("Search By");
                lblSearchBy.setFont(lblSearchBy.getFont().deriveFont(lblSearchBy.getFont().getStyle() | Font.BOLD));

                //======== panel7 ========
                {

                    //---- rbName ----
                    rbName.setText("Name");

                    //---- rbIngredients ----
                    rbIngredients.setText("Ingredients");

                    //---- rbTags ----
                    rbTags.setText("Tags");

                    GroupLayout panel7Layout = new GroupLayout(panel7);
                    panel7.setLayout(panel7Layout);
                    panel7Layout.setHorizontalGroup(
                        panel7Layout.createParallelGroup()
                            .addGroup(panel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(rbName)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbIngredients)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbTags)
                                .addContainerGap())
                    );
                    panel7Layout.setVerticalGroup(
                        panel7Layout.createParallelGroup()
                            .addGroup(panel7Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbName)
                                    .addComponent(rbIngredients)
                                    .addComponent(rbTags))
                                .addContainerGap())
                    );
                }

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(panel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblSearchBy))
                            .addContainerGap(349, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblSearchBy)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                );
            }
            panel1.add(panel2);

            //======== panel3 ========
            {

                //---- btnSearch ----
                btnSearch.setText("Search");
                btnSearch.setHorizontalAlignment(SwingConstants.RIGHT);

                GroupLayout panel3Layout = new GroupLayout(panel3);
                panel3.setLayout(panel3Layout);
                panel3Layout.setHorizontalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(txtSearch)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnSearch)
                            .addContainerGap())
                );
                panel3Layout.setVerticalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel3Layout.createParallelGroup()
                                .addComponent(txtSearch, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnSearch))
                            .addContainerGap())
                );
            }
            panel1.add(panel3);

            //======== panel4 ========
            {
                panel4.setLayout(new BorderLayout());

                //======== panel6 ========
                {

                    //======== scrollPane2 ========
                    {
                        scrollPane2.setViewportView(tblSearchResults);
                    }

                    //---- lblSearchResults ----
                    lblSearchResults.setText("Search Results");
                    lblSearchResults.setFont(lblSearchResults.getFont().deriveFont(lblSearchResults.getFont().getStyle() | Font.BOLD));

                    GroupLayout panel6Layout = new GroupLayout(panel6);
                    panel6.setLayout(panel6Layout);
                    panel6Layout.setHorizontalGroup(
                        panel6Layout.createParallelGroup()
                            .addGroup(panel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(panel6Layout.createParallelGroup()
                                    .addGroup(panel6Layout.createSequentialGroup()
                                        .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                                        .addContainerGap())
                                    .addGroup(panel6Layout.createSequentialGroup()
                                        .addComponent(lblSearchResults, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 482, Short.MAX_VALUE))))
                    );
                    panel6Layout.setVerticalGroup(
                        panel6Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblSearchResults)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                                .addContainerGap())
                    );
                }
                panel4.add(panel6, BorderLayout.CENTER);

                //======== panel5 ========
                {
                    panel5.setLayout(new FlowLayout());

                    //---- btnViewRecipe ----
                    btnViewRecipe.setText("View Recipe");
                    panel5.add(btnViewRecipe);
                }
                panel4.add(panel5, BorderLayout.PAGE_END);
            }
            panel1.add(panel4);
        }
        add(panel1, BorderLayout.CENTER);

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(rbName);
        buttonGroup1.add(rbIngredients);
        buttonGroup1.add(rbTags);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
    private JPanel panel1;
    private JPanel panel2;
    private JLabel lblSearchBy;
    private JPanel panel7;
    private JRadioButton rbName;
    private JRadioButton rbIngredients;
    private JRadioButton rbTags;
    private JPanel panel3;
    private JTextField txtSearch;
    private JButton btnSearch;
    private JPanel panel4;
    private JPanel panel6;
    private JScrollPane scrollPane2;
    private JTable tblSearchResults;
    private JLabel lblSearchResults;
    private JPanel panel5;
    private JButton btnViewRecipe;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

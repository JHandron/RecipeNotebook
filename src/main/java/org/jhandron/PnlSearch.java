/*
 * Created by JFormDesigner on Sun Dec 28 13:50:08 EST 2025
 */

package org.jhandron;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableModel;

/**
 * @author Jason
 */
public class PnlSearch extends JPanel implements SearchView {

    private final PnlSearchController controller;

    public PnlSearch() {
        initComponents();
        controller = new PnlSearchController(this,);
    }

    @Override
    public void bindSearchResultsTableModel(TableModel searchResultsModel) {

    }

    @Override
    public void closeDialog() {

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
        panel1 = new JPanel();
        panel2 = new JPanel();
        label1 = new JLabel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        radioButton3 = new JRadioButton();
        panel3 = new JPanel();
        textField1 = new JTextField();
        button1 = new JButton();
        panel4 = new JPanel();
        panel6 = new JPanel();
        scrollPane2 = new JScrollPane();
        table2 = new JTable();
        label2 = new JLabel();
        panel5 = new JPanel();
        button2 = new JButton();

        //======== this ========
        setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

            //======== panel2 ========
            {

                //---- label1 ----
                label1.setText("Search By");
                label1.setFont(label1.getFont().deriveFont(label1.getFont().getStyle() | Font.BOLD));

                //---- radioButton1 ----
                radioButton1.setText("Name");

                //---- radioButton2 ----
                radioButton2.setText("Ingredients");

                //---- radioButton3 ----
                radioButton3.setText("Tags");

                GroupLayout panel2Layout = new GroupLayout(panel2);
                panel2.setLayout(panel2Layout);
                panel2Layout.setHorizontalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel2Layout.createParallelGroup()
                                .addComponent(label1)
                                .addGroup(panel2Layout.createSequentialGroup()
                                    .addComponent(radioButton1)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(radioButton2)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(radioButton3)))
                            .addContainerGap(361, Short.MAX_VALUE))
                );
                panel2Layout.setVerticalGroup(
                    panel2Layout.createParallelGroup()
                        .addGroup(panel2Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(panel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(radioButton1)
                                .addComponent(radioButton2)
                                .addComponent(radioButton3))
                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
            }
            panel1.add(panel2);

            //======== panel3 ========
            {

                //---- button1 ----
                button1.setText("Search");

                GroupLayout panel3Layout = new GroupLayout(panel3);
                panel3.setLayout(panel3Layout);
                panel3Layout.setHorizontalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(button1)
                            .addContainerGap())
                );
                panel3Layout.setVerticalGroup(
                    panel3Layout.createParallelGroup()
                        .addGroup(panel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addComponent(button1))
                            .addContainerGap(19, Short.MAX_VALUE))
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
                        scrollPane2.setViewportView(table2);
                    }

                    //---- label2 ----
                    label2.setText("Search Results");
                    label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD));

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
                                        .addComponent(label2, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 482, Short.MAX_VALUE))))
                    );
                    panel6Layout.setVerticalGroup(
                        panel6Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel6Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(label2)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrollPane2, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                                .addContainerGap())
                    );
                }
                panel4.add(panel6, BorderLayout.CENTER);

                //======== panel5 ========
                {
                    panel5.setLayout(new FlowLayout());

                    //---- button2 ----
                    button2.setText("View Recipe");
                    panel5.add(button2);
                }
                panel4.add(panel5, BorderLayout.PAGE_END);
            }
            panel1.add(panel4);
        }
        add(panel1, BorderLayout.CENTER);

        //---- buttonGroup1 ----
        var buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
        buttonGroup1.add(radioButton3);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
    private JPanel panel1;
    private JPanel panel2;
    private JLabel label1;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JPanel panel3;
    private JTextField textField1;
    private JButton button1;
    private JPanel panel4;
    private JPanel panel6;
    private JScrollPane scrollPane2;
    private JTable table2;
    private JLabel label2;
    private JPanel panel5;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

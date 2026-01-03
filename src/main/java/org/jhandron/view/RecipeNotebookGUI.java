package org.jhandron.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Jason
 */

public class RecipeNotebookGUI extends JFrame {

    public RecipeNotebookGUI() {
        initComponents();
    }

    private void exitMenuItem(ActionEvent e) {
        System.exit(0);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem3 = new JMenuItem();
        pnlMain = new JPanel();
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        pnlSearch1 = new PnlSearch();
        pnlEdit1 = new PnlEdit();
        pnlAddNew1 = new PnlAddNew();

        //======== this ========
        setTitle("Jason's Recipe Notebook");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new ImageIcon("C:\\Users\\Jason\\Documents\\Projects\\RecipeNotebook\\src\\onkoyybdqdc81.png").getImage());
        setPreferredSize(new Dimension(595, 535));
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("File");

                //---- menuItem3 ----
                menuItem3.setText("Exit");
                menuItem3.addActionListener(e -> exitMenuItem(e));
                menu1.add(menuItem3);
            }
            menuBar1.add(menu1);
        }
        setJMenuBar(menuBar1);

        //======== pnlMain ========
        {
            pnlMain.setMinimumSize(new Dimension(0, 0));
            pnlMain.setLayout(new BorderLayout());

            //======== tabbedPane1 ========
            {

                //======== panel1 ========
                {
                    panel1.setLayout(new CardLayout());
                    panel1.add(pnlSearch1, "cardSearch");
                    panel1.add(pnlEdit1, "cardEdit");
                }
                tabbedPane1.addTab("Search/Edit", panel1);
                tabbedPane1.addTab("Add New", pnlAddNew1);
            }
            pnlMain.add(tabbedPane1, BorderLayout.CENTER);
        }
        contentPane.add(pnlMain, BorderLayout.CENTER);
        setSize(640, 575);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem3;
    private JPanel pnlMain;
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private PnlSearch pnlSearch1;
    private PnlEdit pnlEdit1;
    private PnlAddNew pnlAddNew1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

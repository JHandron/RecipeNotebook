package org.jhandron;

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
        pnlMainCard = new JPanel();
        pnlSearch1 = new PnlSearch();
        pnlAddNew1 = new PnlAddNew();
        pnlEdit1 = new PnlEdit();

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

            //======== pnlMainCard ========
            {
                pnlMainCard.setLayout(new CardLayout());
                pnlMainCard.add(pnlSearch1, "card3");
                pnlMainCard.add(pnlAddNew1, "card1");
                pnlMainCard.add(pnlEdit1, "card2");
            }
            pnlMain.add(pnlMainCard, BorderLayout.CENTER);
        }
        contentPane.add(pnlMain, BorderLayout.CENTER);
        setSize(595, 535);
        setLocationRelativeTo(null);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Jason Handron (j-handron)
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem3;
    private JPanel pnlMain;
    private JPanel pnlMainCard;
    private PnlSearch pnlSearch1;
    private PnlAddNew pnlAddNew1;
    private PnlEdit pnlEdit1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}

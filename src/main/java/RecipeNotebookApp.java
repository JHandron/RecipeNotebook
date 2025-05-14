import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;

public class RecipeNotebookApp {
    public static void main(String[] args) {
        FlatDarkLaf.setup();
        UIManager.put("TabbedPane.showTabSeparators", true);
//        UIManager.put( "TabbedPane.selectedBackground", Color.white);
//        RecipeNotebook recipeNotebook = new RecipeNotebook();
//        recipeNotebook.run();
        RecipeNotebookGUI gui = new RecipeNotebookGUI();
        gui.setVisible(true);
        gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

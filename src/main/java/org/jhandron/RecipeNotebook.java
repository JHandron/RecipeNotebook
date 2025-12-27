package org.jhandron;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;

public class RecipeNotebook {

    public static void main(String[] args) {

        //TODO: Temporary run config setup
        if ("DEV".equals(args[0])) {
            MongoDelegator.COLLECTION_NAME = "recipes-dev";
        } else {
            MongoDelegator.COLLECTION_NAME = "recipes"; //Prod
        }

        FlatDarkLaf.setup();
        UIManager.put("TabbedPane.showTabSeparators", true);
//        UIManager.put( "TabbedPane.selectedBackground", Color.white);
//        RecipeNotebook recipeNotebook = new RecipeNotebook();
//        recipeNotebook.run();

        RecipeNotebookGUI gui = new RecipeNotebookGUI();
        gui.setVisible(true);
    }
}

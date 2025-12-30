package org.jhandron;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class PnlSearchController {

    private final PnlSearch view;
    private final PnlSearchDataController searchDataController;

    public PnlSearchController(PnlSearch p_view) {
        view = p_view;
        searchDataController = p_view.getSearchDataPanel().getController();
    }

    public void handleViewRecipe(int[] selectedIndex) {
        if(selectedIndex.length != 1) {
            System.out.println("Select exactly one row.");
            return;
        }

        Recipe selectedRecipe = searchDataController.getRecipeAt(selectedIndex[0]);
        if (selectedRecipe == null || selectedRecipe.getId() == null) {
            System.out.println("Could not load selected recipe.");
            return;
        }

        Recipe fullRecipe = MongoDelegator.getRecipeById(selectedRecipe.getId());
        if (fullRecipe == null) {
            System.out.println("Could not retrieve recipe from database.");
            return;
        }

        // Navigate to edit panel and populate data
        RecipeNotebookGUI frame = (RecipeNotebookGUI) SwingUtilities.getWindowAncestor(view);
        if (frame == null) {
            System.out.println("Unable to determine parent frame for navigation.");
            return;
        }

        PnlEdit editPanel = frame.pnlEdit1;
        if (editPanel == null) {
            System.out.println("Edit panel not available.");
            return;
        }

        editPanel.getRecipeDataPanel().getController().populateFromRecipe(fullRecipe);

        // Show edit card
        CardLayout layout = (CardLayout) ((JPanel) view.getParent()).getLayout();
        layout.show(view.getParent(), "cardEdit");
    }
}

package org.jhandron;

public class PnlSearchController {

    private final PnlSearch view;
    private final PnlSearchDataController searchDataController;

    public PnlSearchController(PnlSearch p_view) {
        view = p_view;
        searchDataController = p_view.getSearchDataPanel().getController();
    }

    public void handleViewRecipe(int[] selectedIndex) {
        if(selectedIndex.length > 1) {
            System.out.println("Select only one row.");
            return;
        } else {
            //Bring to card layout
        }
    }
}

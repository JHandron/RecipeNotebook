package org.jhandron;

import javax.swing.JButton;

public class DlgSearchController {

    private PnlSearchData searchDataPanel;

    public void bindSearchDataPanel(PnlSearchData searchDataPanel) {
        this.searchDataPanel = searchDataPanel;
    }

    public void registerSelectAction(JButton selectButton) {
        selectButton.addActionListener(e -> handleSelectRecipes());
    }

    private void handleSelectRecipes() {
        if (searchDataPanel == null) {
            return;
        }
        searchDataPanel.getController().handleRecipeSelection(searchDataPanel.getSelectedTableRows());
    }
}

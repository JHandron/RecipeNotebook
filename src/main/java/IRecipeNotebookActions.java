import java.awt.event.ActionEvent;

interface IRecipeNotebookActions {

    public void addRecipeButtonClicked(ActionEvent e);

    public void findButtonClicked(ActionEvent e);

    public void rbNameSelected(ActionEvent e);

    public void rbInstructionSelected(ActionEvent e);

    public void rbIngredientsSelected(ActionEvent e);

    public void rbTagsSelected(ActionEvent e);

    //Naming these methods "Entered" since that's when the event fires
    public void txtIngredientsEntered(ActionEvent e);

    public void txtTagsEntered(ActionEvent e);
}

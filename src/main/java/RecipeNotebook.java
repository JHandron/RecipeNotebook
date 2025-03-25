import javax.swing.*;

public class RecipeNotebook {

    private final JFrame frame;

    public RecipeNotebook(){
        RecipeNotebookActionEvents events = new RecipeNotebookActionEvents();
        events.bindListModelsAndActions();

        frame = new JFrame("Recipe Notebook");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450,580); //TODO: Why do this here?
        frame.add(RecipeNotebookActionEvents.GUI); //TODO: find more intuitive way to bind this
    }

    public void run() {
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); //This is to center the frame upon launching
    }
}

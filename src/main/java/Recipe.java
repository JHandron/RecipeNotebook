import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String id;
    private String name;
    private String instructions;
    private List<String> ingredientList;
    private List<String> tagsList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public List<String> getIngredientList() {
        return ingredientList == null ? new ArrayList<>() : ingredientList;
    }

    public void setIngredientList(List<String> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public List<String> getTagsList() {
        return tagsList == null ? new ArrayList<>() : tagsList;
    }

    public void setTagsList(List<String> tagsList) {
        this.tagsList = tagsList;
    }
}

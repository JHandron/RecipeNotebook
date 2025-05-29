package org.jhandron;
import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String id;
    private String name;
    private String instructions;
    private List<String> ingredientList;
    private List<String> tagsList;
    private List<String> relatedRecipeList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
/*
### GET ALL ELECTRO PLEAS BAYBEEEEEEE!

GET https://payitsux.net/api/wordpress/nyscourts/data/probably-insecure/?data="Unknown"
Authorization Basic erfgt4qt4t33t223

### POST BAYBEEE
POST https://payitsux.net/api/wordpress/nyscourts/data/probably-insecure/
Authorization Basic erfgt4qt4t33t223
Accepts-Content-Type: MIME:JSON

{
"docket_id" : 12345,
"sealed" : true,
"display_public_seals": false
}


 */
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

    public List<String> getRelatedRecipeList() {
        return relatedRecipeList;
    }

    public void setRelatedRecipeList(List<String> relatedRecipeList) {
        this.relatedRecipeList = relatedRecipeList;
    }
}

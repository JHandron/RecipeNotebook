package org.jhandron;
import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonRepresentation;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Recipe {

    @BsonId
    @BsonRepresentation(BsonType.OBJECT_ID)
    private String id;

    private String name;
    private String instructions;
    private List<String> ingredients;
    private List<String> tags;
    private List<String> relatedRecipes;


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

    public List<String> getIngredients() {
        return ingredients == null ? new ArrayList<>() : ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getTags() {
        return tags == null ? new ArrayList<>() : tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getRelatedRecipes() {
        return relatedRecipes;
    }

    public void setRelatedRecipes(List<String> relatedRecipes) {
        this.relatedRecipes = relatedRecipes;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("; ");
        sj.add(id);
        sj.add(name);
        sj.add(instructions);
//        sj.add(ingredients.toString());
//        sj.add(tags.toString());
//        sj.add(relatedRecipes.toString());
        return sj.toString();
    }
}

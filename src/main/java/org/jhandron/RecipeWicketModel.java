package org.jhandron;

import org.apache.wicket.model.LoadableDetachableModel;
import org.bson.Document;

import java.util.StringJoiner;

public class RecipeWicketModel extends LoadableDetachableModel<String> {
    String r = "";

    public RecipeWicketModel(String r) {
        super(r);
        this.r = r;
    }

    @Override
    protected String load() {
        Recipe recipe = MongoDelegator.getByName(r);
        StringJoiner sj = new StringJoiner("\n");
        System.out.println(recipe.toString());
        sj.add(recipe.getName() + "(" + recipe.getId() +" )");
        sj.add(recipe.getInstructions());
        return sj.toString() ;
    }
}

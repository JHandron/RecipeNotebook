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
        Document rec = MongoDelegator.getByName(r);
        StringJoiner sj = new StringJoiner("\n");
        System.out.println(rec);
        sj.add(rec.get("name").toString() + "(" + rec.get("id").toString() + ")");
        sj.add(rec.get("instuctions").toString());
        return sj.toString() ;
    }
}

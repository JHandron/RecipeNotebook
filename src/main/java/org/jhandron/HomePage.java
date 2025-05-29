package org.jhandron;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class HomePage extends WebPage {
    public HomePage() {

       // add(new Label("RecipeLabel"),)
        add(new Label("message", new RecipeWicketModel("Food")));
    }
}
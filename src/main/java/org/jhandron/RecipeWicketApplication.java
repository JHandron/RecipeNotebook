package org.jhandron;

import org.apache.wicket.protocol.http.WebApplication;

public class RecipeWicketApplication extends WebApplication {
    @Override
    public Class<HomePage> getHomePage() {
        return HomePage.class;
    }
}

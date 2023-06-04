package com.mendix.recipe.model;

import java.util.List;

public class RecipeHead {
    private String title;
    private List<Category> categories;
    private int yield;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public int getYield() {
        return yield;
    }

    public void setYield(int yield) {
        this.yield = yield;
    }

    public RecipeHead(String title, List<Category> categories, int yield) {
        this.title = title;
        this.categories = categories;
        this.yield = yield;
    }

}

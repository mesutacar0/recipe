package com.mendix.recipe.model;

import java.util.List;

public class IngredientDivision {
    private String title;
    private List<Ingredient> ingredientList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public IngredientDivision(String title, List<Ingredient> ingredientList) {
        this.title = title;
        this.ingredientList = ingredientList;
    }

}

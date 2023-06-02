package com.mendix.recipe.model;

import java.util.List;

public class IngredientDivision {
    private String title;
    private List<Ingredient> ingredientList;

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the ingredientList
     */
    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    /**
     * @param ingredientList the ingredientList to set
     */
    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

}

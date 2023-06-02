package com.mendix.recipe.model;

import java.util.List;

public class Reciepe {
    private String title;
    private List<RecipeCategory> categories;
    private List<IngredientDivision> ingredients;

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
     * @return the categories
     */
    public List<RecipeCategory> getCategories() {
        return categories;
    }

    /**
     * @param categories the categories to set
     */
    public void setCategories(List<RecipeCategory> categories) {
        this.categories = categories;
    }

    /**
     * @return the ingredients
     */
    public List<IngredientDivision> getIngredients() {
        return ingredients;
    }

    /**
     * @param ingredients the ingredients to set
     */
    public void setIngredients(List<IngredientDivision> ingredients) {
        this.ingredients = ingredients;
    }

}

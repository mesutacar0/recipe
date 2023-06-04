package com.mendix.recipe.model;

import java.util.List;

public class Recipe {
    private String title;
    private List<Category> categories;
    private List<IngredientDivision> ingredients;
    private Ingredient ingredient;
    private List<String> descriptionSteps;

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

    public List<IngredientDivision> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientDivision> ingredients) {
        this.ingredients = ingredients;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public List<String> getDescriptionSteps() {
        return descriptionSteps;
    }

    public void setDescriptionSteps(List<String> descriptionSteps) {
        this.descriptionSteps = descriptionSteps;
    }

}

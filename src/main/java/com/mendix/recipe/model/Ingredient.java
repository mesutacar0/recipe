package com.mendix.recipe.model;

public class Ingredient {
    private String item;
    private IngredientAmount amount;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public IngredientAmount getAmount() {
        return amount;
    }

    public void setAmount(IngredientAmount amount) {
        this.amount = amount;
    }

    public Ingredient(String item, IngredientAmount amount) {
        this.item = item;
        this.amount = amount;
    }

}

package com.mendix.recipe.model;

public class Ingredient {
    private String item;
    private IngredientAmount amount;

    /**
     * @return the item
     */
    public String getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(String item) {
        this.item = item;
    }

    /**
     * @return the amount
     */
    public IngredientAmount getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(IngredientAmount amount) {
        this.amount = amount;
    }

}

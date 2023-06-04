package com.mendix.recipe.model;

public class IngredientAmount {
    private String quantity;
    private String unit;

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public IngredientAmount(String quantity, String unit) {
        this.quantity = quantity;
        this.unit = unit;
    }

}

package com.mendix.recipe.model;

import com.mendix.recipe.util.AmountUnit;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class IngredientAmount {
    private int quantity;
    @Enumerated(EnumType.STRING)
    private AmountUnit unit;

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the unit
     */
    public AmountUnit getUnit() {
        return unit;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(AmountUnit unit) {
        this.unit = unit;
    }

    /**
     * @param quantity
     * @param unit
     */
    public IngredientAmount(int quantity, AmountUnit unit) {
        this.quantity = quantity;
        this.unit = unit;
    }

}

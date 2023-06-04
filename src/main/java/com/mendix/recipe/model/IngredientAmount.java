package com.mendix.recipe.model;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "amt")
@XmlAccessorType(XmlAccessType.FIELD)
public class IngredientAmount {
    @XmlElement(name = "qty")
    private String quantity;
    @XmlElement(name = "unit")
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

    public IngredientAmount() {
    }

}

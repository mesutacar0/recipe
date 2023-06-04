package com.mendix.recipe.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ing")
public class Ingredient {

    @XmlElement(name = "item")
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

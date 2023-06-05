package com.mendix.recipe.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "ingredients")
public class IngredientWrapper {

    private List<IngredientDivision> ingredientDivs;

    private List<Ingredient> ingredients;

    @XmlElement(name = "ing-div", nillable = true)
    public List<IngredientDivision> getIngredientDivs() {
        return ingredientDivs;
    }

    public void setIngredientDivs(List<IngredientDivision> ingredientDivs) {
        this.ingredientDivs = ingredientDivs;
    }

    @XmlElement(name = "ing", nillable = true)
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}

package com.mendix.recipe.model;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ing-div")
public class IngredientDivision {

    private String title;
    private List<Ingredient> ingredients;

    @XmlElement(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public IngredientDivision(String title, List<Ingredient> ingredientList) {
        this.title = title;
        this.ingredients = ingredientList;
    }

    public IngredientDivision() {
    }

    @XmlElement(name = "ing")
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}

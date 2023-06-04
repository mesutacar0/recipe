package com.mendix.recipe.model;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "ing-div")
public class IngredientDivision {

    @XmlElement(name = "title")
    private String title;
    private List<Ingredient> ingredientList;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    public IngredientDivision(String title, List<Ingredient> ingredientList) {
        this.title = title;
        this.ingredientList = ingredientList;
    }

    public IngredientDivision() {
    }

}

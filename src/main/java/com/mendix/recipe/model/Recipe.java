package com.mendix.recipe.model;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "recipe")
@XmlAccessorType(XmlAccessType.FIELD)
public class Recipe {

    private RecipeHead head;
    // @XmlElement(name = "ing-div")
    @XmlTransient
    private List<IngredientDivision> ingredientDivs;
    @XmlElementWrapper(name = "ingredients")
    @XmlElement(name = "ing")
    private List<Ingredient> ingredients;
    private Direction directions;

    public Recipe() {
    }

    public RecipeHead getHead() {
        return head;
    }

    public void setHead(RecipeHead head) {
        this.head = head;
    }

    public List<IngredientDivision> getIngredientDivs() {
        return ingredientDivs;
    }

    public void setIngredientDivs(List<IngredientDivision> ingredientDivs) {
        this.ingredientDivs = ingredientDivs;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Direction getDirections() {
        return directions;
    }

    public void setDirections(Direction directions) {
        this.directions = directions;
    }
}

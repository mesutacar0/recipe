package com.mendix.recipe.model;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "recipe")
@XmlAccessorType(XmlAccessType.FIELD)
public class Recipe {

    private RecipeHead head;
    private IngredientWrapper ingredients;
    private Direction directions;

    public Recipe() {
    }

    public RecipeHead getHead() {
        return head;
    }

    public void setHead(RecipeHead head) {
        this.head = head;
    }

    public Direction getDirections() {
        return directions;
    }

    public void setDirections(Direction directions) {
        this.directions = directions;
    }

    public IngredientWrapper getIngredients() {
        return ingredients;
    }

    public void setIngredients(IngredientWrapper ingredients) {
        this.ingredients = ingredients;
    }
}

package com.mendix.recipe.model;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "recipe")
public class Recipe {

    private RecipeHead head;
    private List<IngredientDivision> ingredients;
    @XmlElement(name = "ingredients")
    private Ingredient ingredient;
    private Direction directions;

    public RecipeHead getHead() {
        return head;
    }

    public void setHead(RecipeHead head) {
        this.head = head;
    }

    public List<IngredientDivision> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientDivision> ingredients) {
        this.ingredients = ingredients;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Direction getDirections() {
        return directions;
    }

    public void setDirections(Direction directions) {
        this.directions = directions;
    }

    public Recipe(RecipeHead head, List<IngredientDivision> ingredients, Ingredient ingredient, Direction directions) {
        this.head = head;
        this.ingredients = ingredients;
        this.ingredient = ingredient;
        this.directions = directions;
    }

    public Recipe() {
    }

}

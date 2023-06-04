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

    /**
     * @return the head
     */
    public RecipeHead getHead() {
        return head;
    }

    /**
     * @param head the head to set
     */
    public void setHead(RecipeHead head) {
        this.head = head;
    }

    /**
     * @return the ingredientDivs
     */
    public List<IngredientDivision> getIngredientDivs() {
        return ingredientDivs;
    }

    /**
     * @param ingredientDivs the ingredientDivs to set
     */
    public void setIngredientDivs(List<IngredientDivision> ingredientDivs) {
        this.ingredientDivs = ingredientDivs;
    }

    /**
     * @return the ingredients
     */
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * @param ingredients the ingredients to set
     */
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * @return the directions
     */
    public Direction getDirections() {
        return directions;
    }

    /**
     * @param directions the directions to set
     */
    public void setDirections(Direction directions) {
        this.directions = directions;
    }

}

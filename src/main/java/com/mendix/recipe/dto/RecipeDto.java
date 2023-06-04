package com.mendix.recipe.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Recipe Model Information")
public class RecipeDto {

    private RecipeHeadDto head;
    private List<IngredientDivisionDto> ingredientDivs;
    private List<IngredientDto> ingredients;
    private DirectionDto directions;

    /**
     * @return the head
     */
    public RecipeHeadDto getHead() {
        return head;
    }

    /**
     * @param head the head to set
     */
    public void setHead(RecipeHeadDto head) {
        this.head = head;
    }

    /**
     * @return the ingredientDivs
     */
    public List<IngredientDivisionDto> getIngredientDivs() {
        return ingredientDivs;
    }

    /**
     * @param ingredientDivs the ingredientDivs to set
     */
    public void setIngredientDivs(List<IngredientDivisionDto> ingredientDivs) {
        this.ingredientDivs = ingredientDivs;
    }

    /**
     * @return the ingredients
     */
    public List<IngredientDto> getIngredients() {
        return ingredients;
    }

    /**
     * @param ingredients the ingredients to set
     */
    public void setIngredients(List<IngredientDto> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * @return the directions
     */
    public DirectionDto getDirections() {
        return directions;
    }

    /**
     * @param directions the directions to set
     */
    public void setDirections(DirectionDto directions) {
        this.directions = directions;
    }

    /**
     * 
     */
    public RecipeDto() {
    }

}

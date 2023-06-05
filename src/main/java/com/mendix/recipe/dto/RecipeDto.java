package com.mendix.recipe.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Recipe Model Information")
public class RecipeDto {

    private RecipeHeadDto head;
    private List<IngredientDivisionDto> ingredientDivs;
    private List<IngredientDto> ingredients;
    private DirectionDto directions;

    public RecipeHeadDto getHead() {
        return head;
    }

    public void setHead(RecipeHeadDto head) {
        this.head = head;
    }

    public List<IngredientDivisionDto> getIngredientDivs() {
        return ingredientDivs;
    }

    public void setIngredientDivs(List<IngredientDivisionDto> ingredientDivs) {
        this.ingredientDivs = ingredientDivs;
    }

    public List<IngredientDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientDto> ingredients) {
        this.ingredients = ingredients;
    }

    public DirectionDto getDirections() {
        return directions;
    }

    public void setDirections(DirectionDto directions) {
        this.directions = directions;
    }

    public RecipeDto() {
    }
}

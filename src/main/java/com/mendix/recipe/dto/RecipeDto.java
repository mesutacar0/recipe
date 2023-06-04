package com.mendix.recipe.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Recipe Model Information")
public class RecipeDto {

    private RecipeHeadDto head;
    private List<IngredientDivisionDto> ingredients;
    private IngredientDto ingredient;
    private DirectionDto directions;

    public RecipeHeadDto getHead() {
        return head;
    }

    public void setHead(RecipeHeadDto head) {
        this.head = head;
    }

    public List<IngredientDivisionDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientDivisionDto> ingredients) {
        this.ingredients = ingredients;
    }

    public IngredientDto getIngredient() {
        return ingredient;
    }

    public void setIngredient(IngredientDto ingredient) {
        this.ingredient = ingredient;
    }

    public DirectionDto getDirections() {
        return directions;
    }

    public void setDirections(DirectionDto directions) {
        this.directions = directions;
    }

    public RecipeDto(RecipeHeadDto head, List<IngredientDivisionDto> ingredients, IngredientDto ingredient,
            DirectionDto directions) {
        this.head = head;
        this.ingredients = ingredients;
        this.ingredient = ingredient;
        this.directions = directions;
    }

}

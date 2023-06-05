package com.mendix.recipe.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Recipe Ingredient Part Model Information")
public class IngredientWrapperDto {

    private List<IngredientDivisionDto> ingredientDivs;
    private List<IngredientDto> ingredients;

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

}

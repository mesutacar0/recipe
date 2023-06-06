package com.mendix.recipe.dto;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Recipe Ingredient Part Model Information")
public class IngredientWrapperDto {

    private List<IngredientDivisionDto> ingredientDivs = new ArrayList<>();
    private List<IngredientDto> ingredients = new ArrayList<>();

    public List<IngredientDivisionDto> getIngredientDivs() {
        return ingredientDivs;
    }

    public void setIngredientDivs(List<IngredientDivisionDto> ingredientDivs) {
        if (ingredientDivs != null)
            this.ingredientDivs = ingredientDivs;
    }

    public List<IngredientDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientDto> ingredients) {
        if (ingredients != null)
            this.ingredients = ingredients;
    }

}

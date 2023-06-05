package com.mendix.recipe.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Recipe Ingredient Division Information")
public class IngredientDivisionDto {
    @Schema(description = "Ingredient division title", example = "GLAZE")
    private String title;
    private List<IngredientDto> ingredients;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<IngredientDto> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientDto> ingredients) {
        this.ingredients = ingredients;
    }

    public IngredientDivisionDto(String title, List<IngredientDto> ingredients) {
        this.title = title;
        this.ingredients = ingredients;
    }
}

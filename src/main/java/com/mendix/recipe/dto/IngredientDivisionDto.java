package com.mendix.recipe.dto;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

@Schema(name = "Ingredient Division", description = "Recipe Ingredient Division Information")
public class IngredientDivisionDto {

    @Schema(description = "Ingredient division title", example = "GLAZE")
    private String title;
    @NotEmpty(message = "Ingredients cannot be empty")
    @Valid
    private List<IngredientDto> ingredients = new ArrayList<>();

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

}

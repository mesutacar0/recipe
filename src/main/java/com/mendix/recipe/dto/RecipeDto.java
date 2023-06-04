package com.mendix.recipe.dto;

import java.util.List;

import com.mendix.recipe.model.Ingredient;
import com.mendix.recipe.model.IngredientDivision;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Recipe Model Information")
public class RecipeDto {

    @Schema(description = "Recipe's title", example = "Recipe Title")
    private String title;
    @Schema(description = "Recipe's categories", example = "Microwave")
    private List<CategoryDto> categories;
    private List<IngredientDivision> ingredients;
    private Ingredient ingredient;
    private List<String> descriptionSteps;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CategoryDto> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDto> categories) {
        this.categories = categories;
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

    public List<String> getDescriptionSteps() {
        return descriptionSteps;
    }

    public void setDescriptionSteps(List<String> descriptionSteps) {
        this.descriptionSteps = descriptionSteps;
    }

}

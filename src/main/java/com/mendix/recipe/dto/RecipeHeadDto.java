package com.mendix.recipe.dto;

import java.util.ArrayList;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

@Schema(name = "Recipe Head", description = "Recipe Head Model Information")
public class RecipeHeadDto {

    @Schema(description = "Recipe Title", example = "Amaretto Cake")
    @NotEmpty(message = "Recipe title is mandatory")
    private String title;
    @NotEmpty(message = "Recipe categories cannot be empty")
    @Valid
    private List<CategoryDto> categories = new ArrayList<>();
    @Schema(description = "Recipe Yield", example = "1")
    private int yield;

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

    public int getYield() {
        return yield;
    }

    public void setYield(int yield) {
        this.yield = yield;
    }
}

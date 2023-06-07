package com.mendix.recipe.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

@Schema(description = "Recipe Head Model Information")
public class RecipeHeadDto {

    @Schema(description = "Recipe Title", example = "Amaretto Cake")
    @NotEmpty
    @JsonProperty(required = true)
    private String title;
    @NotEmpty
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

    public RecipeHeadDto(String title, List<CategoryDto> categories, int yield) {
        this.title = title;
        this.categories = categories;
        this.yield = yield;
    }

    public RecipeHeadDto() {
    }

}

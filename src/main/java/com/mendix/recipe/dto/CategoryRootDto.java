package com.mendix.recipe.dto;

import java.util.List;

public class CategoryRootDto {

    private String name;
    private List<RecipeDto> recipes;

    public String getName() {
        return name;
    }

    public List<RecipeDto> getRecipes() {
        return recipes;
    }

    public CategoryRootDto(String name, List<RecipeDto> recipes) {
        this.name = name;
        this.recipes = recipes;
    }

}

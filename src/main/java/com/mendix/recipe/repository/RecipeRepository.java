package com.mendix.recipe.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mendix.recipe.model.Recipe;

@Component
public class RecipeRepository {

    private List<Recipe> recipes = new ArrayList<>();

    public void save(Recipe recipe) {
        this.recipes.add(recipe);
    }

    public List<Recipe> findAll() {
        return this.recipes;
    }

    public List<Recipe> findByCategory(String category) {
        return this.recipes.stream().filter(r -> r.getHead().getCategories().contains(category)).toList();
    }

}

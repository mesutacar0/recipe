package com.mendix.recipe.repository.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mendix.recipe.model.Recipe;
import com.mendix.recipe.repository.interfaces.RecipeRepository;

@Repository
public class RecipeRepositoryImpl implements RecipeRepository {

    private List<Recipe> recipes = new ArrayList<>();

    @Override
    public Recipe save(Recipe recipe) {
        this.recipes.add(recipe);
        return recipe;
    }

    @Override
    public List<Recipe> findAll() {
        return recipes;
    }

    @Override
    public List<Recipe> findByCategory(String category) {
        return this.recipes.stream().filter(r -> r.getHead().getCategories().contains(category)).toList();
    }

    @Override
    public List<Recipe> searchByKeyword(String keyword) {
        return this.recipes.stream().filter(r -> r.getHead().getCategories().contains(keyword)
                || r.getHead().getTitle().toLowerCase().contains(keyword.toLowerCase())).toList();
    }
}

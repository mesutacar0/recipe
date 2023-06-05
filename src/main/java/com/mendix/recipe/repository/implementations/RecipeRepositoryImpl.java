package com.mendix.recipe.repository.implementations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mendix.recipe.model.Recipe;
import com.mendix.recipe.repository.interfaces.CategoryRepository;
import com.mendix.recipe.repository.interfaces.RecipeRepository;

@Repository
public class RecipeRepositoryImpl implements RecipeRepository {

    @Autowired
    CategoryRepository categoryRepository;

    private Map<String, Recipe> recipes = new HashMap<>();

    @Override
    public Recipe save(Recipe recipe) {
        recipe.getHead().getCategories().forEach(categoryRepository::save);
        this.recipes.put(recipe.getHead().getTitle().toLowerCase(), recipe);
        return recipe;
    }

    @Override
    public List<Recipe> findAll() {
        return recipes.values().stream().toList();
    }

    @Override
    public List<Recipe> findByCategory(String category) {
        return recipes.values().stream().filter(r -> r.getHead().getCategories().contains(category)).toList();
    }

    @Override
    public List<Recipe> searchByKeyword(String keyword) {
        return this.recipes.values().stream().filter(r -> r.getHead().getCategories().contains(keyword)
                || r.getHead().getTitle().toLowerCase().contains(keyword.toLowerCase())).toList();
    }
}

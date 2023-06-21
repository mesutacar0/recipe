package com.mendix.recipe.repository.implementations;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mendix.recipe.model.Recipe;
import com.mendix.recipe.repository.interfaces.RecipeRepository;

@Repository
public class RecipeRepositoryImpl implements RecipeRepository {

    private final Map<String, Recipe> recipes = new HashMap<>();

    @Override
    public Recipe save(Recipe recipe) {
        recipes.put(recipe.getId(), recipe);
        return recipe;
    }

    @Override
    public Collection<Recipe> findAll() {
        return recipes.values();
    }

    @Override
    public Boolean existsById(String id) {
        return recipes.containsKey(id);
    }

    @Override
    public Recipe findById(String id) {
        return recipes.get(id);
    }

    @Override
    public void deleteAll() {
        recipes.clear();
    }
}

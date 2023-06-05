package com.mendix.recipe.repository.interfaces;

import java.util.List;

import com.mendix.recipe.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, String> {
    public List<Recipe> findByCategory(String category);

    public List<Recipe> searchByKeyword(String keyword);
}

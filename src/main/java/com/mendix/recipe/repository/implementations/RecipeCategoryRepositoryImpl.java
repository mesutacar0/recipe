package com.mendix.recipe.repository.implementations;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.mendix.recipe.repository.interfaces.RecipeCategoryRepository;

@Repository
public class RecipeCategoryRepositoryImpl implements RecipeCategoryRepository {

    private final Map<String, Set<String>> categoryRecipeMap = new HashMap<>();

    @Override
    public void save(String category, String recipe) {
        categoryRecipeMap.putIfAbsent(category, new HashSet<>());
        categoryRecipeMap.get(category).add(recipe);
    }

    @Override
    public Set<String> findByCategory(String category) {
        Set<String> result = categoryRecipeMap.get(category);
        if (result == null)
            return Collections.emptySet();
        return categoryRecipeMap.get(category);
    }
}

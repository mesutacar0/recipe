package com.mendix.recipe.repository.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.mendix.recipe.repository.interfaces.RecipeCategoryRepository;

@Repository
public class RecipeCategoryRepositoryImpl implements RecipeCategoryRepository {

    private Map<String, Set<String>> categoryRecipeMap = new HashMap<>();

    @Override
    public void save(String category, String recipe) {
        if (existsById(category)) {
            categoryRecipeMap.get(category).add(recipe);
        } else {
            categoryRecipeMap.put(category, Set.of(recipe));
        }
    }

    private Boolean existsById(String id) {
        return categoryRecipeMap.containsKey(id);
    }

    @Override
    public Optional<List<String>> findByCategory(String category) {
        return Optional.of(categoryRecipeMap.get(category).stream().collect(Collectors.toList()));
    }
}

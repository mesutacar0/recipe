package com.mendix.recipe.repository.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.mendix.recipe.repository.interfaces.RecipeKeywordRepository;

@Repository
public class RecipeKeywordRepositoryImpl implements RecipeKeywordRepository {

    private Map<String, Set<String>> keywordRecipeMap = new HashMap<>();

    @Override
    public void save(String keyword, String recipe) {
        if (existsById(keyword)) {
            keywordRecipeMap.get(keyword).add(recipe);
        } else {
            keywordRecipeMap.put(keyword, Set.of(recipe));
        }
    }

    private Boolean existsById(String id) {
        return keywordRecipeMap.containsKey(id);
    }

    @Override
    public List<String> findByKeyword(String keyword) {
        return keywordRecipeMap.get(keyword).stream().collect(Collectors.toList());
    }

}

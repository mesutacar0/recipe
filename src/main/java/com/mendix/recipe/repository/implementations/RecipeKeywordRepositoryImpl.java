package com.mendix.recipe.repository.implementations;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.mendix.recipe.repository.interfaces.RecipeKeywordRepository;

@Repository
public class RecipeKeywordRepositoryImpl implements RecipeKeywordRepository {

    private final Map<String, Set<String>> keywordRecipeMap = new HashMap<>();

    @Override
    public void save(String keyword, String recipe) {
        keywordRecipeMap.putIfAbsent(keyword, new HashSet<>());
        keywordRecipeMap.get(keyword).add(recipe);
    }

    @Override
    public Set<String> findByKeyword(String keyword) {
        Set<String> result = keywordRecipeMap.get(keyword);
        if (result == null)
            return Collections.emptySet();
        return keywordRecipeMap.get(keyword);
    }

}

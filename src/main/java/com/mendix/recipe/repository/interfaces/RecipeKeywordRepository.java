package com.mendix.recipe.repository.interfaces;

import java.util.Set;

public interface RecipeKeywordRepository {
    void save(String keyword, String recipe);

    Set<String> findByKeyword(String keyword);

    void deleteAll();
}

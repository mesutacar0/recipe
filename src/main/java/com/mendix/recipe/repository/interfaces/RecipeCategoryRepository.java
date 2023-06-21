package com.mendix.recipe.repository.interfaces;

import java.util.Set;

public interface RecipeCategoryRepository {

    void save(String category, String recipe);

    Set<String> findByCategory(String category);

    void deleteAll();
}

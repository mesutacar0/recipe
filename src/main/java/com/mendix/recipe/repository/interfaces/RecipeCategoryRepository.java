package com.mendix.recipe.repository.interfaces;

import java.util.List;
import java.util.Optional;

public interface RecipeCategoryRepository {

    void save(String category, String recipe);

    Optional<List<String>> findByCategory(String category);
}

package com.mendix.recipe.repository.interfaces;

import java.util.List;
import java.util.Optional;

public interface RecipeKeywordRepository {
    void save(String keyword, String recipe);

    List<String> findByKeyword(String keyword);
}

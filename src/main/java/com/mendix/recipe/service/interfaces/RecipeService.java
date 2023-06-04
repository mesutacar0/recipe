package com.mendix.recipe.service.interfaces;

import java.util.List;

import com.mendix.recipe.dto.CategoryDto;
import com.mendix.recipe.dto.RecipeDto;

public interface RecipeService {

    List<RecipeDto> findAll();

    List<RecipeDto> findByCategory(CategoryDto category);

    List<RecipeDto> searchByKeyword(String keyword);

    RecipeDto save(RecipeDto recipe);

    void init();
}

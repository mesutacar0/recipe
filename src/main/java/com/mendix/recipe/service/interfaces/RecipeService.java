package com.mendix.recipe.service.interfaces;

import java.util.List;

import com.mendix.recipe.dto.RecipeDto;

public interface RecipeService {

    List<RecipeDto> findAll();

    RecipeDto findByTitle(String title);

    List<RecipeDto> findByCategory(String category);

    List<RecipeDto> searchByKeyword(String keyword);

    RecipeDto save(RecipeDto recipe);

    void deleteAll();

}

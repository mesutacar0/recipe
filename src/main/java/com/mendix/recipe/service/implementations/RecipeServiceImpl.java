package com.mendix.recipe.service.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendix.recipe.dto.CategoryDto;
import com.mendix.recipe.dto.RecipeDto;
import com.mendix.recipe.mapper.RecipeMapper;
import com.mendix.recipe.model.Recipe;
import com.mendix.recipe.service.interfaces.RecipeService;

@Service
public class RecipeServiceImpl implements RecipeService {

    static List<Recipe> recipes = new ArrayList<>();

    @Autowired
    RecipeMapper recipeMapper;

    @Override
    public List<RecipeDto> findAll() {
        return recipes.stream().map(recipeMapper::recipeToRecipeDto).collect(Collectors.toList());
    }

    @Override
    public List<RecipeDto> findByCategory(CategoryDto category) {
        return recipes.stream().map(recipeMapper::recipeToRecipeDto)
                .filter(r -> r.getHead().getCategories().contains(category))
                .toList();
    }

    @Override
    public RecipeDto save(RecipeDto recipe) {
        recipes.add(recipeMapper.recipeDtoToRecipe(recipe));
        return recipe;
    }

    @Override
    public List<RecipeDto> searchByKeyword(String keyword) {
        return recipes.stream().filter(r -> r.toString().contains(keyword)).map(recipeMapper::recipeToRecipeDto)
                .toList();
    }

}

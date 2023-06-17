package com.mendix.recipe.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mendix.recipe.dto.RecipeDto;
import com.mendix.recipe.model.Recipe;

@Mapper(componentModel = "spring")
public interface RecipeMapper {
    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    RecipeDto recipeToRecipeDto(Recipe recipe);

    Recipe recipeDtoToRecipe(RecipeDto recipeDto);

}

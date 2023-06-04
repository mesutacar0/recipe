package com.mendix.recipe.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import com.mendix.recipe.dto.CategoryDto;
import com.mendix.recipe.dto.RecipeDto;
import com.mendix.recipe.model.Recipe;

@Mapper(componentModel = "spring")
public interface RecipeMapper {
    RecipeMapper INSTANCE = Mappers.getMapper(RecipeMapper.class);

    RecipeDto recipeToRecipeDto(Recipe recipe);

    // @Mapping(source = "category", target = "category", qualifiedByName =
    // "categorytoString")
    Recipe recipeDtoToRecipe(RecipeDto recipeDto);

    @Named("categorytoString")
    public static String categorytoString(CategoryDto categoryDto) {
        return categoryDto.getName();
    }
}

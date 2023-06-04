package com.mendix.recipe.mapper;

import java.util.List;

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

    @Mapping(source = "head.categories", target = "head.categories", qualifiedByName = "stringToCategory")
    RecipeDto recipeToRecipeDto(Recipe recipe);

    @Mapping(source = "head.categories", target = "head.categories", qualifiedByName = "categoryToString")
    Recipe recipeDtoToRecipe(RecipeDto recipeDto);

    @Named("categoryToString")
    public static List<String> categoryToString(List<CategoryDto> categoryDtos) {
        return categoryDtos.stream().map(CategoryDto::getName).toList();
    }

    @Named("stringToCategory")
    public static List<CategoryDto> stringToCategory(List<String> categories) {
        return categories.stream().map(CategoryDto::new).toList();
    }

}

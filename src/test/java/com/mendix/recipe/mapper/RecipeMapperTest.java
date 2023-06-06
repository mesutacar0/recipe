package com.mendix.recipe.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.mendix.recipe.dto.CategoryDto;

public class RecipeMapperTest {

    @Autowired
    RecipeMapper recipeMapper;

    @Test
    void testCategoryToString() {
        CategoryDto categoryDto = new CategoryDto("Category");
        String cat = "Category";

        List<String> mappedCat = RecipeMapper.categoryToString(List.of(categoryDto));

        mappedCat.forEach(c -> assertEquals(c, cat));
    }

    @Test
    void testRecipeDtoToRecipe() {

    }

    @Test
    void testRecipeToRecipeDto() {

    }

}

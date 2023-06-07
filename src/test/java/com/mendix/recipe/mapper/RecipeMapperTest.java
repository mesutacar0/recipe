package com.mendix.recipe.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mendix.recipe.dto.CategoryDto;
import com.mendix.recipe.dto.RecipeDto;
import com.mendix.recipe.dto.RecipeHeadDto;
import com.mendix.recipe.model.Category;
import com.mendix.recipe.model.Recipe;
import com.mendix.recipe.model.RecipeHead;

@SpringBootTest
public class RecipeMapperTest {

    @Autowired
    RecipeMapper recipeMapper;

    @Test
    void givenStringList_thenMappedCategoryList_shouldBeEqual() {
        CategoryDto categoryDto = new CategoryDto("Category");
        String cat = new String("Category");

        List<String> mappedCat = RecipeMapper.categoryToString(List.of(categoryDto));

        mappedCat.forEach(c -> assertEquals(c, cat));
    }

    @Test
    void givenRecipe_shouldReturnEqualDto() {
        Recipe recipe = new Recipe();
        RecipeHead recipeHead = new RecipeHead();
        recipeHead.setTitle("Recipe1");
        recipeHead.setCategories(List.of("category"));
        recipe.setHead(recipeHead);

        RecipeDto recipeDto = new RecipeDto();
        RecipeHeadDto recipeHeadDto = new RecipeHeadDto();
        recipeHeadDto.setTitle("Recipe1");
        CategoryDto categoryDto = new CategoryDto("category");
        recipeHeadDto.setCategories(List.of(categoryDto));
        recipeDto.setHead(recipeHeadDto);

        RecipeDto mappedRecipeDto = recipeMapper.recipeToRecipeDto(recipe);

        assertEquals(mappedRecipeDto, recipeDto);
    }

    @Test
    void givenRecipe_whenCaseSensitive_shouldReturnEqualDto() {
        Recipe recipe = new Recipe();
        RecipeHead recipeHead = new RecipeHead();
        recipeHead.setTitle("Recipe1");
        recipeHead.setCategories(List.of("category"));
        recipe.setHead(recipeHead);

        RecipeDto recipeDto = new RecipeDto();
        RecipeHeadDto recipeHeadDto = new RecipeHeadDto();
        recipeHeadDto.setTitle("Recipe1");
        CategoryDto categoryDto = new CategoryDto("category");
        recipeHeadDto.setCategories(List.of(categoryDto));
        recipeDto.setHead(recipeHeadDto);

        RecipeDto mappedRecipeDto = recipeMapper.recipeToRecipeDto(recipe);

        assertEquals(mappedRecipeDto, recipeDto);
    }

}

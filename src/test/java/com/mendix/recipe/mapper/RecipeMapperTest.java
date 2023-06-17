package com.mendix.recipe.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mendix.recipe.dto.CategoryDto;
import com.mendix.recipe.dto.RecipeDto;
import com.mendix.recipe.dto.RecipeHeadDto;
import com.mendix.recipe.model.Category;
import com.mendix.recipe.model.Recipe;
import com.mendix.recipe.model.RecipeHead;
import com.mendix.recipe.service.implementations.ApplicationStartupService;

@SpringBootTest
public class RecipeMapperTest {

    @MockBean
    ApplicationStartupService applicationStartupService;

    @Autowired
    RecipeMapper recipeMapper;

    Recipe recipe = new Recipe();
    Recipe mappedRecipe = new Recipe();
    RecipeHead recipeHead = new RecipeHead();
    Category category = new Category();

    RecipeDto recipeDto = new RecipeDto();
    RecipeHeadDto recipeHeadDto = new RecipeHeadDto();
    CategoryDto categoryDto = new CategoryDto();

    @BeforeEach
    void setup() {
        recipeHead.setTitle("Recipe1");
        category.setName("cateogry");
        recipeHead.setCategories(List.of(category));
        recipe.setHead(recipeHead);

        categoryDto.setName("category");
        recipeHeadDto.setCategories(List.of(categoryDto));
        recipeDto.setHead(recipeHeadDto);
    }

    @Test
    void givenRecipeDto_shouldReturnEqual_whenMapped() {
        recipeHeadDto.setTitle("Recipe1");

        mappedRecipe = recipeMapper.recipeDtoToRecipe(recipeDto);

        assertEquals(mappedRecipe, recipe, "Mapped Recipe DTO should be equal to Recipe");
    }

    @Test
    void givenRecipeDto_shouldReturnNOTEqual_whenMappedAnother() {
        recipeHeadDto.setTitle("Recipe2");

        mappedRecipe = recipeMapper.recipeDtoToRecipe(recipeDto);

        assertNotEquals(mappedRecipe, recipe, "Different Recipe DTO should not be equal to Recipe");
    }

    @Test
    void givenRecipe_whenCaseSensitive_shouldReturnEqual() {
        recipeHeadDto.setTitle("recipe1");

        Recipe mappedRecipe = recipeMapper.recipeDtoToRecipe(recipeDto);

        assertEquals(mappedRecipe, recipe, "Mapped Case Sensitive Recipe DTO should be equal to Recipe");
    }

}

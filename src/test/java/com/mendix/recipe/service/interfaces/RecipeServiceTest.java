package com.mendix.recipe.service.interfaces;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mendix.recipe.dto.CategoryDto;
import com.mendix.recipe.dto.RecipeDto;
import com.mendix.recipe.dto.RecipeHeadDto;

@SpringBootTest
// @TestInstance(Lifecycle.PER_CLASS)
public class RecipeServiceTest {

    @Autowired
    RecipeService recipeService;

    // category title keyword vs'yi UNID ile olustur, sonra match ediyor mu diye
    // bak.
    // list all category ile ayni
    // save

    @Test
    void should_return_allSavedRecipes() {
        RecipeDto recipeDto1 = new RecipeDto();
        RecipeDto recipeDto2 = new RecipeDto();
        RecipeDto recipeDto3 = new RecipeDto();
        RecipeHeadDto recipeHeadDto = new RecipeHeadDto();
        recipeHeadDto.setTitle("Recipe1");
        CategoryDto categoryDto = new CategoryDto("category");
        recipeHeadDto.setCategories(List.of(categoryDto));
        recipeDto1.setHead(recipeHeadDto);
        recipeHeadDto.setTitle("Recipe2");
        recipeDto2.setHead(recipeHeadDto);
        recipeHeadDto.setTitle("Recipe3");
        recipeDto3.setHead(recipeHeadDto);
        List<RecipeDto> givenRecipeList = Arrays.asList(recipeDto1, recipeDto2, recipeDto3);

        List<RecipeDto> recipeDtos = recipeService.findAll();

        assertTrue(recipeDtos.containsAll(givenRecipeList), " Saved recipes must appear in search result");
    }

    @Test
    void testFindByCategory() {

    }

    @Test
    void testInit() {

    }

    @Test
    void should_ReturnTrue_when_Saved() {
        // Given
        String cat1 = "Category1";

        // When
        // Then
    }

    @Test
    void testSearchByKeyword() {
        recipeService.save(new RecipeDto());
    }

}

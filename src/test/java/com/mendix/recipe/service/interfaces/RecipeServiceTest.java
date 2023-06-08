package com.mendix.recipe.service.interfaces;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mendix.recipe.dto.CategoryDto;
import com.mendix.recipe.dto.IngredientWrapperDto;
import com.mendix.recipe.dto.RecipeDto;
import com.mendix.recipe.dto.RecipeHeadDto;

import jakarta.persistence.EntityExistsException;

@SpringBootTest
// @TestInstance(Lifecycle.PER_CLASS)
public class RecipeServiceTest {

    @Autowired
    RecipeService recipeService;

    @BeforeEach
    void emptyRepository() {
        recipeService.deleteAll();
    }

    @Test
    void givenRecipes_whenSaved_thenShouldFound() {
        RecipeDto recipeDto1 = new RecipeDto();
        RecipeDto recipeDto2 = new RecipeDto();
        RecipeDto recipeDto3 = new RecipeDto();
        IngredientWrapperDto ingredientWrapperDto = new IngredientWrapperDto();
        CategoryDto categoryDto = new CategoryDto("category");
        RecipeHeadDto recipeHeadDto1 = new RecipeHeadDto();
        RecipeHeadDto recipeHeadDto2 = new RecipeHeadDto();
        RecipeHeadDto recipeHeadDto3 = new RecipeHeadDto();
        recipeHeadDto1.setCategories(List.of(categoryDto));
        recipeHeadDto2.setCategories(List.of(categoryDto));
        recipeHeadDto3.setCategories(List.of(categoryDto));
        recipeHeadDto1.setTitle("Recipe1");
        recipeHeadDto2.setTitle("Recipe2");
        recipeHeadDto3.setTitle("Recipe3");
        recipeDto1.setHead(recipeHeadDto1);
        recipeDto1.setIngredients(ingredientWrapperDto);
        recipeDto2.setHead(recipeHeadDto2);
        recipeDto2.setIngredients(ingredientWrapperDto);
        recipeDto3.setHead(recipeHeadDto3);
        recipeDto3.setIngredients(ingredientWrapperDto);
        List<RecipeDto> givenRecipeList = Arrays.asList(recipeDto1, recipeDto2, recipeDto3);

        recipeService.save(recipeDto1);
        recipeService.save(recipeDto2);
        recipeService.save(recipeDto3);
        List<RecipeDto> recipeDtos = recipeService.findAll();

        assertTrue(recipeDtos.containsAll(givenRecipeList), " Saved recipes must appear in search result");
    }

    @Test
    void givenSameRecipe_whenSaved_thenShouldThrowEntitityExistsException() {
        RecipeDto recipeDto = new RecipeDto();
        RecipeDto recipeDtoSameTitle = new RecipeDto();
        RecipeHeadDto recipeHeadDto = new RecipeHeadDto();
        IngredientWrapperDto ingredientWrapperDto = new IngredientWrapperDto();
        recipeHeadDto.setTitle("Recipe1");
        CategoryDto categoryDto = new CategoryDto("category");
        recipeHeadDto.setCategories(List.of(categoryDto));
        recipeDto.setHead(recipeHeadDto);
        recipeDto.setIngredients(ingredientWrapperDto);
        recipeHeadDto.setTitle("Recipe1");
        recipeDtoSameTitle.setHead(recipeHeadDto);
        recipeDtoSameTitle.setIngredients(ingredientWrapperDto);
        recipeService.save(recipeDto);

        assertThrows(EntityExistsException.class, () -> recipeService.save(recipeDtoSameTitle),
                "Balance must be greater than amount of withdrawal");
    }

    @Test
    void givenCategory_whenSaved_thenShouldBeFound() {
        String uniqueCat = UUID.randomUUID().toString();
        CategoryDto category = new CategoryDto(uniqueCat);
        RecipeDto recipeDto = new RecipeDto();
        RecipeHeadDto recipeHeadDto = new RecipeHeadDto();
        IngredientWrapperDto ingredientWrapperDto = new IngredientWrapperDto();
        recipeHeadDto.setTitle("Recipe");
        recipeHeadDto.setCategories(List.of(category));
        recipeDto.setHead(recipeHeadDto);
        recipeDto.setIngredients(ingredientWrapperDto);

        recipeService.save(recipeDto);

        assertFalse(recipeService.findByCategory(uniqueCat).size() == 0,
                "Saved Recipe with a unique category should be found in repository");
    }

    @Test
    void givenUniquekeyInCategory_whenSaved_thenShouldBeFoundByKeyword() {
        String uniqueKeyword = "AuniqueKeyWordInsideCategory";
        CategoryDto category = new CategoryDto(uniqueKeyword);
        RecipeDto recipeDto = new RecipeDto();
        RecipeHeadDto recipeHeadDto = new RecipeHeadDto();
        IngredientWrapperDto ingredientWrapperDto = new IngredientWrapperDto();
        recipeHeadDto.setTitle("Recipe");
        recipeHeadDto.setCategories(List.of(category));
        recipeDto.setHead(recipeHeadDto);
        recipeDto.setIngredients(ingredientWrapperDto);

        recipeService.save(recipeDto);

        assertFalse(recipeService.searchByKeyword(uniqueKeyword).size() == 0,
                "Saved Recipe with a unique keyword in category should be found in repository");
    }

    @Test
    void givenUniquekeyInTitle_whenSaved_thenShouldBeFoundByKeyword() {
        String uniqueKeyword = "AuniqueKeywordInsideTitle";
        CategoryDto category = new CategoryDto("Category");
        RecipeHeadDto recipeHeadDto = new RecipeHeadDto();
        IngredientWrapperDto ingredientWrapperDto = new IngredientWrapperDto();
        RecipeDto recipeDto = new RecipeDto();
        recipeHeadDto.setTitle(uniqueKeyword);
        recipeHeadDto.setCategories(List.of(category));
        recipeDto.setHead(recipeHeadDto);
        recipeDto.setIngredients(ingredientWrapperDto);

        recipeService.save(recipeDto);

        assertFalse(recipeService.searchByKeyword(uniqueKeyword).size() == 0,
                "Saved Recipe with a unique keyword in category should be found in repository");
    }

    @Test
    void givenUniquekey_whenSaved_thenShouldBeFoundByLowerCaseKeyword() {
        String uniqueKeyword = "AuniqueKeywordInsideTitle";
        String uniqueKeywordLowerCase = uniqueKeyword.toLowerCase();
        CategoryDto category = new CategoryDto("Category");
        RecipeHeadDto recipeHeadDto = new RecipeHeadDto();
        IngredientWrapperDto ingredientWrapperDto = new IngredientWrapperDto();
        RecipeDto recipeDto = new RecipeDto();
        recipeHeadDto.setTitle(uniqueKeyword);
        recipeHeadDto.setCategories(List.of(category));
        recipeDto.setHead(recipeHeadDto);
        recipeDto.setIngredients(ingredientWrapperDto);

        recipeService.save(recipeDto);

        assertFalse(recipeService.searchByKeyword(uniqueKeywordLowerCase).size() == 0,
                "Saved Recipe with a unique keyword in category should be found in repository when search by lowercase");
    }

    @Test
    void givenLowerCaseUniquekey_whenSaved_thenShouldBeFoundByUpperCase() {
        String uniqueKeyword = "auniqueKeywordInsideTitle";
        String uniqueKeywordUpperCase = uniqueKeyword.toUpperCase();
        CategoryDto category = new CategoryDto("Category");
        RecipeHeadDto recipeHeadDto = new RecipeHeadDto();
        IngredientWrapperDto ingredientWrapperDto = new IngredientWrapperDto();
        RecipeDto recipeDto = new RecipeDto();
        recipeHeadDto.setTitle(uniqueKeyword);
        recipeHeadDto.setCategories(List.of(category));
        recipeDto.setHead(recipeHeadDto);
        recipeDto.setIngredients(ingredientWrapperDto);

        recipeService.save(recipeDto);

        assertFalse(recipeService.searchByKeyword(uniqueKeywordUpperCase).size() == 0,
                "Saved Recipe with a unique keyword in category should be found in repository when search by lowercase");
    }

}

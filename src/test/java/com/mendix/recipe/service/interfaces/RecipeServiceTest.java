package com.mendix.recipe.service.interfaces;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mendix.recipe.dto.CategoryDto;
import com.mendix.recipe.dto.IngredientWrapperDto;
import com.mendix.recipe.dto.RecipeDto;
import com.mendix.recipe.dto.RecipeHeadDto;
import com.mendix.recipe.service.implementations.ApplicationStartupService;

import jakarta.persistence.EntityExistsException;

@SpringBootTest
public class RecipeServiceTest {

    @MockBean
    ApplicationStartupService applicationStartupService;

    @Autowired
    RecipeService recipeService;

    RecipeDto recipeDto1 = new RecipeDto();
    RecipeDto recipeDto2 = new RecipeDto();
    RecipeDto recipeDto3 = new RecipeDto();
    IngredientWrapperDto ingredientWrapperDto = new IngredientWrapperDto();
    RecipeHeadDto recipeHeadDto1 = new RecipeHeadDto();
    RecipeHeadDto recipeHeadDto2 = new RecipeHeadDto();
    RecipeHeadDto recipeHeadDto3 = new RecipeHeadDto();
    CategoryDto categoryDto = new CategoryDto();

    @BeforeEach
    void emptyRepository() {
        recipeService.deleteAll();
    }

    @BeforeEach
    void setup() {
        categoryDto.setName("Category");
        recipeHeadDto1.setCategories(List.of(categoryDto));
        recipeHeadDto2.setCategories(List.of(categoryDto));
        recipeHeadDto3.setCategories(List.of(categoryDto));

        recipeHeadDto1.setTitle("Recipe1");
        recipeHeadDto2.setTitle("Recipe2");
        recipeHeadDto3.setTitle("Recipe3");

        recipeDto1.setIngredients(ingredientWrapperDto);
        recipeDto1.setHead(recipeHeadDto1);
        recipeDto2.setIngredients(ingredientWrapperDto);
        recipeDto2.setHead(recipeHeadDto2);
        recipeDto3.setIngredients(ingredientWrapperDto);
        recipeDto3.setHead(recipeHeadDto3);
    }

    @Test
    void givenRecipes_whenSaved_thenShouldFound() {
        List<RecipeDto> givenRecipeList = Arrays.asList(recipeDto1, recipeDto2, recipeDto3);

        recipeService.save(recipeDto1);
        recipeService.save(recipeDto2);
        recipeService.save(recipeDto3);
        List<RecipeDto> recipeDtos = recipeService.findAll();

        assertTrue(recipeDtos.containsAll(givenRecipeList), " Saved recipes must appear in search result");
    }

    @Test
    void givenSameRecipe_whenSaved_thenShouldThrowEntitityExistsException() {
        RecipeDto recipeDtoSameTitle = recipeDto1;
        recipeService.save(recipeDto1);

        assertThrows(EntityExistsException.class, () -> recipeService.save(recipeDtoSameTitle),
                "EntityExistsException should be thrown when same recipe saved");
    }

    @Test
    void givenCategory_whenSaved_thenShouldBeFound() {
        String uniqueCat = UUID.randomUUID().toString();
        categoryDto.setName(uniqueCat);

        recipeService.save(recipeDto1);

        assertNotEquals(recipeService.findByCategory(uniqueCat).size(), 0,
                "Saved Recipe with a unique category should be found in repository");
    }

    @Test
    void givenUniquekeyInCategory_whenSaved_thenShouldBeFoundByKeyword() {
        String uniqueKeyword = "AuniqueKeyWordInsideCategory";
        categoryDto.setName(uniqueKeyword);

        recipeService.save(recipeDto1);

        assertNotEquals(recipeService.searchByKeyword(uniqueKeyword).size(), 0,
                "Saved Recipe with a unique keyword in category should be found in repository");
    }

    @Test
    void givenUniquekeyInTitle_whenSaved_thenShouldBeFoundByKeyword() {
        String uniqueKeyword = "AuniqueKeywordInsideTitle";
        recipeHeadDto1.setTitle(uniqueKeyword);

        recipeService.save(recipeDto1);

        assertNotEquals(recipeService.searchByKeyword(uniqueKeyword).size(), 0,
                "Saved Recipe with a unique keyword in category should be found in repository");
    }

    @Test
    void givenUniquekey_whenSaved_thenShouldBeFoundByLowerCaseKeyword() {
        String uniqueKeyword = "AuniqueKeywordInsideTitle";
        String uniqueKeywordLowerCase = uniqueKeyword.toLowerCase();
        recipeHeadDto1.setTitle(uniqueKeyword);

        recipeService.save(recipeDto1);

        assertNotEquals(recipeService.searchByKeyword(uniqueKeywordLowerCase).size(), 0,
                "Saved Recipe with a unique keyword in category should be found in repository when search by lowercase");
    }

    @Test
    void givenLowerCaseUniquekey_whenSaved_thenShouldBeFoundByUpperCase() {
        String uniqueKeyword = "auniqueKeywordInsideTitle";
        String uniqueKeywordUpperCase = uniqueKeyword.toUpperCase();
        recipeHeadDto1.setTitle(uniqueKeyword);

        recipeService.save(recipeDto1);

        assertNotEquals(recipeService.searchByKeyword(uniqueKeywordUpperCase).size(), 0,
                "Saved Recipe with a unique keyword in category should be found in repository when search by lowercase");
    }

}

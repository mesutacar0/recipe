package com.mendix.recipe.service.interfaces;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RecipeServiceTest {

    @Autowired
    RecipeService recipeService;

    @Test
    void testFindAll() {

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

    }
}

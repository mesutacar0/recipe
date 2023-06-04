package com.mendix.recipe.service.interfaces;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mendix.recipe.dto.CategoryDto;

@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    CategoryService categoryService;

    @Test
    void testFindAll() {

        CategoryDto cat1 = new CategoryDto("cat1");
        CategoryDto cat2 = new CategoryDto("cat2");
        CategoryDto cat3 = new CategoryDto("cat3");

        categoryService.save(cat1);
        categoryService.save(cat2);
        categoryService.save(cat3);

        Set<CategoryDto> catList = categoryService.findAll();

        assertEquals(catList.stream().count(), 3);

    }

    @Test
    void should_ReturnTrue_when_Saved() {
        // Given
        String cat1 = "Category1";
        CategoryDto category1 = new CategoryDto(cat1);

        // When
        CategoryDto categoryResult = categoryService.save(category1);

        // Then
        assertEquals(cat1, categoryResult.getName());
    }
}

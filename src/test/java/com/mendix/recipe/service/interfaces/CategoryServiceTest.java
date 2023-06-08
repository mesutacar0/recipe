package com.mendix.recipe.service.interfaces;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mendix.recipe.dto.CategoryDto;

@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    CategoryService categoryService;

    @BeforeEach
    void emptyRepository() {
        categoryService.deleteAll();
    }

    @Test
    void givenCategories_whenSaved_thenReturnTrue() {
        CategoryDto cat1 = new CategoryDto("cat1");
        CategoryDto cat2 = new CategoryDto("cat2");
        CategoryDto cat3 = new CategoryDto("cat3");
        categoryService.save(cat1);
        categoryService.save(cat2);
        categoryService.save(cat3);
        List<CategoryDto> catListGiven = Arrays.asList(cat1, cat2, cat3);

        List<CategoryDto> catList = categoryService.findAll();

        assertTrue(catList.containsAll(catListGiven), "Saved categories must appear in search result");
    }

    @Test
    void givenCategoryWithSameName_whenNotSaved_thenReturnTrue() {
        CategoryDto cat1 = new CategoryDto("cat1");
        CategoryDto cat2 = new CategoryDto("cat1");
        categoryService.save(cat1);
        int count = categoryService.findAll().size();

        categoryService.save(cat2);
        int countNew = categoryService.findAll().size();

        assertTrue(count == countNew, "Category with same name should not be inserted");
    }

    @Test
    void givenCategoryWithUniqueId_whenSaved_thenShouldFound() {
        String uniqueCategory = UUID.randomUUID().toString();
        CategoryDto category = new CategoryDto(uniqueCategory);

        categoryService.save(category);

        assertTrue(categoryService.findAll().stream().anyMatch(c -> c.equals(category)),
                "Saved category with unique id should be found in repository");
    }
}

package com.mendix.recipe.service.interfaces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mendix.recipe.mapper.CategoryMapper;
import com.mendix.recipe.model.Category;
import com.mendix.recipe.service.implementations.ApplicationStartupService;

@SpringBootTest
public class CategoryServiceTest {

    @MockBean
    ApplicationStartupService applicationStartupService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryMapper categoryMapper;

    Category category1 = new Category();
    Category category2 = new Category();
    Category category3 = new Category();

    @BeforeEach
    void emptyRepository() {
        categoryService.deleteAll();
    }

    @BeforeEach
    void setup() {
        category1.setName("Category1");
        category2.setName("Category2");
        category3.setName("Category3");
    }

    @Test
    void givenCategories_whenSaved_thenReturnTrue() {
        categoryService.save(category1);
        categoryService.save(category2);
        categoryService.save(category3);
        List<Category> categoryListGiven = Arrays.asList(category1, category2, category3);

        List<Category> categoryList = categoryService.findAll().stream().map(categoryMapper::categoryDtoToCategory)
                .toList();

        assertTrue(categoryList.containsAll(categoryListGiven), "Saved categories must appear in search result");
    }

    @Test
    void givenCategoryWithSameName_whenNotSaved_thenReturnTrue() {
        Category categorySame = new Category();
        categorySame.setName("Category1");
        categoryService.save(category1);
        int countBeforeSameSaved = categoryService.findAll().size();

        categoryService.save(categorySame);
        int countAfterSameSaved = categoryService.findAll().size();

        assertEquals(countBeforeSameSaved, countAfterSameSaved, "Category with same name should not be inserted");
    }

    @Test
    void givenCategoryWithUniqueId_whenSaved_thenShouldFound() {
        String uniqueCategoryName = UUID.randomUUID().toString();
        category1.setName(uniqueCategoryName);

        categoryService.save(category1);

        assertTrue(
                categoryService.findAll().stream().map(categoryMapper::categoryDtoToCategory)
                        .anyMatch(category -> category.equals(category1)),
                "Saved category with unique id should be found in repository");
    }
}

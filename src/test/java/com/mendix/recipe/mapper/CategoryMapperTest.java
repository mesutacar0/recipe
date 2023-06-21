package com.mendix.recipe.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.mendix.recipe.dto.CategoryDto;
import com.mendix.recipe.model.Category;
import com.mendix.recipe.service.implementations.ApplicationStartupService;

@SpringBootTest
public class CategoryMapperTest {

    @MockBean
    ApplicationStartupService applicationStartupService;

    @Autowired
    CategoryMapper categoryMapper;

    Category category = new Category();
    Category mappedCategory = new Category();
    CategoryDto categoryDto = new CategoryDto();

    @BeforeEach
    void setup() {
        category.setName("Category");
    }

    @Test
    void givenCategoryDto_shouldReturnEqual_whenMapped() {
        categoryDto.setName("Category");

        mappedCategory = categoryMapper.categoryDtoToCategory(categoryDto);

        assertEquals(mappedCategory, category, "Mapped Category DTO should be equal to Category");
    }

    @Test
    void givenCategoryDto_shouldReturnNOTEqual_whenMappedAnother() {
        categoryDto.setName("CategoryOther");

        mappedCategory = categoryMapper.categoryDtoToCategory(categoryDto);

        assertNotEquals(mappedCategory, category, "Different Category DTO should not be equal to Category");
    }

    @Test
    void givenCategory_whenCaseSensitive_shouldReturnEqual() {
        categoryDto.setName("category");

        mappedCategory = categoryMapper.categoryDtoToCategory(categoryDto);

        assertEquals(mappedCategory, category, "Mapped Case Sensitive Category DTO should be equal to Category");
    }

}

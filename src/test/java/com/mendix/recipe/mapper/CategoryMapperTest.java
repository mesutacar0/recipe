package com.mendix.recipe.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mendix.recipe.dto.CategoryDto;

@SpringBootTest
public class CategoryMapperTest {

    @Autowired
    CategoryMapper categoryMapper;

    @Test
    void givenString_whenMapped_thenReturnEqualCategory() {
        String cat = "Category";
        CategoryDto givenCategoryDto = new CategoryDto("Category");

        CategoryDto mappedCategoryDto = categoryMapper.stringToCategory(cat);

        assertEquals(givenCategoryDto, mappedCategoryDto);
    }

    @Test
    void givenString_whenMappedAnother_thenReturnNotEqualCategory() {
        String cat = "Category Other";
        CategoryDto givenCategoryDto = new CategoryDto("Category");

        CategoryDto mappedCategoryDto = categoryMapper.stringToCategory(cat);

        assertNotEquals(givenCategoryDto, mappedCategoryDto);
    }

    @Test
    void givenString_whenMapped_thenReturnSameCategory_ifCase() {
        String cat = "Category";
        CategoryDto givenCategoryDto = new CategoryDto("category");

        CategoryDto mappedCategoryDto = categoryMapper.stringToCategory(cat);

        assertEquals(givenCategoryDto, mappedCategoryDto);
    }

    @Test
    void givenEmptyString_whenMapped_thenReturnSameCategory() {
        String cat = new String();
        CategoryDto givenCategoryDto = new CategoryDto(cat);

        CategoryDto mappedCategoryDto = categoryMapper.stringToCategory(cat);

        assertEquals(givenCategoryDto, mappedCategoryDto);
    }

}

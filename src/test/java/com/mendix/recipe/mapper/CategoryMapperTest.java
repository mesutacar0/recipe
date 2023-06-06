package com.mendix.recipe.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mendix.recipe.dto.CategoryDto;

@SpringBootTest
public class CategoryMapperTest {

    @Autowired
    CategoryMapper categoryMapper;

    @Test
    void testStringToCategory() {
        String cat = "Category";
        CategoryDto categoryDto = new CategoryDto("Category");

        CategoryDto mappedCategoryDto = categoryMapper.stringToCategory(cat);

        assertEquals(categoryDto, mappedCategoryDto);
    }
}

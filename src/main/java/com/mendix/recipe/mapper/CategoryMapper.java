package com.mendix.recipe.mapper;

import org.springframework.stereotype.Component;

import com.mendix.recipe.dto.CategoryDto;

@Component
public class CategoryMapper {

    public CategoryDto stringToCategory(String category) {
        return new CategoryDto(category);
    }
}

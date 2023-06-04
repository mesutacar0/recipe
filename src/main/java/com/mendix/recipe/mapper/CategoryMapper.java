package com.mendix.recipe.mapper;

import org.aspectj.weaver.ast.CallExpr;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.mendix.recipe.dto.CategoryDto;
import com.mendix.recipe.model.Category;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto categoryToCategoryDto(String category);

    String categoryDtoToCategory(CategoryDto categoryDto);
}

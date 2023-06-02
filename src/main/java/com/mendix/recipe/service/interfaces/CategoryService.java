package com.mendix.recipe.service.interfaces;

import java.util.List;

import com.mendix.recipe.dto.CategoryDto;

public interface CategoryService {

    List<CategoryDto> findAll();

    CategoryDto save(CategoryDto category);
}

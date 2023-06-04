package com.mendix.recipe.service.interfaces;

import java.util.Set;

import com.mendix.recipe.dto.CategoryDto;

public interface CategoryService {

    Set<CategoryDto> findAll();

    CategoryDto save(CategoryDto category);
}

package com.mendix.recipe.service.implementations;

import java.util.ArrayList;
import java.util.List;

import com.mendix.recipe.dto.CategoryDto;
import com.mendix.recipe.service.interfaces.CategoryService;

public class CategoryServiceImpl implements CategoryService {

    static List<CategoryDto> categories = new ArrayList<CategoryDto>();

    @Override
    public List<CategoryDto> findAll() {
        return categories;
    }

    @Override
    public CategoryDto save(CategoryDto category) {
        categories.add(category);
        return category;
    }

}

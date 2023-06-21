package com.mendix.recipe.service.interfaces;

import java.util.List;

import com.mendix.recipe.dto.CategoryDto;
import com.mendix.recipe.model.Category;

public interface CategoryService {

    List<CategoryDto> findAll();

    void save(Category category);

    void deleteAll();
}

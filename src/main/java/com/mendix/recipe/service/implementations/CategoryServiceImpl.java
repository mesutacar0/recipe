package com.mendix.recipe.service.implementations;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendix.recipe.dto.CategoryDto;
import com.mendix.recipe.mapper.CategoryMapper;
import com.mendix.recipe.model.Category;
import com.mendix.recipe.service.interfaces.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    static Set<String> categories = new HashSet<>();

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public Set<CategoryDto> findAll() {
        return categories.stream().map(categoryMapper::categoryToCategoryDto).collect(Collectors.toSet());
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        categories.add(categoryMapper.categoryDtoToCategory(categoryDto));
        return categoryDto;
    }

}

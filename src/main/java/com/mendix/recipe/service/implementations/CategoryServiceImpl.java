package com.mendix.recipe.service.implementations;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendix.recipe.dto.CategoryDto;
import com.mendix.recipe.mapper.CategoryMapper;
import com.mendix.recipe.repository.interfaces.CategoryRepository;
import com.mendix.recipe.service.interfaces.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> findAll() {
        return StreamSupport.stream(categoryRepository.findAll().spliterator(), false)
                .map(categoryMapper::stringToCategory).toList();
    }

    @Override
    public void save(CategoryDto categoryDto) {
        if (!isExists(categoryDto))
            categoryMapper.stringToCategory(categoryRepository.save(categoryDto.getName()));
    }

    private Boolean isExists(CategoryDto categoryDto) {
        return categoryRepository.existsById(categoryDto.getName().toLowerCase());
    }

}

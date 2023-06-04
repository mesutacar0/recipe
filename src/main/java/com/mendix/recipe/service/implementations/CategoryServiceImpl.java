package com.mendix.recipe.service.implementations;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendix.recipe.dto.CategoryDto;
import com.mendix.recipe.mapper.CategoryMapper;
import com.mendix.recipe.repository.CategoryRepository;
import com.mendix.recipe.service.interfaces.CategoryService;

import jakarta.persistence.EntityExistsException;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Set<CategoryDto> findAll() {
        List<String> res = categoryRepository.findAll();
        return res.stream().map(categoryMapper::stringToCategory)
                .collect(Collectors.toSet());
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        if (isExists(categoryDto))
            throw new EntityExistsException();

        categoryRepository.save(categoryDto.getName());
        return categoryDto;
    }

    public Boolean isExists(CategoryDto categoryDto) {
        return categoryRepository.findAll().stream().map(categoryMapper::stringToCategory)
                .anyMatch(c -> c.equals(categoryDto));
    }

}

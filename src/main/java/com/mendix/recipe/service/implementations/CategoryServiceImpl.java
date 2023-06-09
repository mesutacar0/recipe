package com.mendix.recipe.service.implementations;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendix.recipe.dto.CategoryDto;
import com.mendix.recipe.mapper.CategoryMapper;
import com.mendix.recipe.model.Category;
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
                .map(categoryMapper::categoryToCategoryDto).toList();
    }

    @Override
    public synchronized void save(Category category) {
        if (!isExists(category))
            categoryRepository.save(category);
    }

    private boolean isExists(Category category) {
        return categoryRepository.existsById(category.getId());
    }

    @Override
    public void deleteAll() {
        categoryRepository.deleteAll();
    }

}

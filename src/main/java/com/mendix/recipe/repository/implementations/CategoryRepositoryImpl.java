package com.mendix.recipe.repository.implementations;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mendix.recipe.model.Category;
import com.mendix.recipe.repository.interfaces.CategoryRepository;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private final Map<String, Category> categories = new HashMap<>();

    @Override
    public Category save(Category category) {
        categories.put(category.getId(), category);
        return category;
    }

    @Override
    public Collection<Category> findAll() {
        return categories.values();
    }

    @Override
    public Boolean existsById(String id) {
        return categories.containsKey(id);
    }

    @Override
    public Category findById(String id) {
        return categories.get(id);
    }

    @Override
    public void deleteAll() {
        categories.clear();
    }
}

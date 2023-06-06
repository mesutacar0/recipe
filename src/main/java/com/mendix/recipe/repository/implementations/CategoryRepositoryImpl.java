package com.mendix.recipe.repository.implementations;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mendix.recipe.repository.interfaces.CategoryRepository;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private Map<String, String> categories = new HashMap<>();

    @Override
    public String save(String category) {
        categories.put(category.toLowerCase(), category);
        return category;
    }

    @Override
    public List<String> findAll() {
        return categories.values().stream().toList();
    }

    @Override
    public Boolean existsById(String id) {
        return categories.containsKey(id);
    }

    @Override
    public String findById(String id) {
        return categories.get(id);
    }
}

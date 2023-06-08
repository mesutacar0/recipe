package com.mendix.recipe.repository.implementations;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.mendix.recipe.repository.interfaces.CategoryRepository;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private final Map<String, String> categories = new HashMap<>();

    @Override
    public String save(String category) {
        categories.put(getId(category), category);
        return category;
    }

    @Override
    public Collection<String> findAll() {
        return categories.values();
    }

    @Override
    public Boolean existsById(String id) {
        return categories.containsKey(id);
    }

    @Override
    public String findById(String id) {
        return categories.get(id);
    }

    @Override
    public String getId(String entity) {
        return entity.toLowerCase();
    }

    @Override
    public void deleteAll() {
        categories.clear();
    }
}

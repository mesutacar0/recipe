package com.mendix.recipe.repository.implementations;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.mendix.recipe.repository.interfaces.CategoryRepository;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

    private Set<String> categories = new HashSet<>();

    @Override
    public String save(String entity) {
        categories.add(entity);
        return entity;
    }

    @Override
    public Set<String> findAll() {
        return categories;
    }
}

package com.mendix.recipe.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class CategoryRepository {

    private List<String> categories = new ArrayList<>();

    public void save(String category) {
        this.categories.add(category);
    }

    public List<String> findAll() {
        return this.categories;
    }
}

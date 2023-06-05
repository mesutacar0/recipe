package com.mendix.recipe.service.implementations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.mendix.recipe.dto.CategoryDto;
import com.mendix.recipe.dto.RecipeDto;
import com.mendix.recipe.mapper.RecipeMapper;
import com.mendix.recipe.repository.interfaces.RecipeRepository;
import com.mendix.recipe.service.interfaces.RecipeService;
import com.mendix.recipe.util.XMLOperations;

import jakarta.persistence.EntityExistsException;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    RecipeMapper recipeMapper;

    @Autowired
    RecipeRepository recipeRepository;

    @Override
    public List<RecipeDto> findAll() {
        return StreamSupport.stream(recipeRepository.findAll().spliterator(), false)
                .map(recipeMapper::recipeToRecipeDto).collect(Collectors.toList());
    }

    @Override
    public List<RecipeDto> findByCategory(CategoryDto category) {
        return recipeRepository.findByCategory(category.getName()).stream().map(recipeMapper::recipeToRecipeDto)
                .toList();
    }

    @Override
    public RecipeDto save(RecipeDto recipe) {
        if (isExists(recipe))
            throw new EntityExistsException();
        recipeRepository.save(recipeMapper.recipeDtoToRecipe(recipe));
        return recipe;
    }

    @Override
    public List<RecipeDto> searchByKeyword(String keyword) {
        return StreamSupport.stream(recipeRepository.findAll().spliterator(), false)
                .filter(r -> r.toString().contains(keyword))
                .map(recipeMapper::recipeToRecipeDto)
                .toList();
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        XMLOperations.loadInitialFiles().forEach(recipeXml -> recipeRepository.save(recipeXml.getRecipe()));
    }

    private Boolean isExists(RecipeDto recipe) {
        return StreamSupport.stream(recipeRepository.findAll().spliterator(), false)
                .map(recipeMapper::recipeToRecipeDto)
                .anyMatch(c -> c.equals(recipe));

    }

}

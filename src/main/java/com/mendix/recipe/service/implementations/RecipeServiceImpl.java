package com.mendix.recipe.service.implementations;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.mendix.recipe.dto.CategoryDto;
import com.mendix.recipe.dto.RecipeDto;
import com.mendix.recipe.mapper.RecipeMapper;
import com.mendix.recipe.repository.interfaces.RecipeCategoryRepository;
import com.mendix.recipe.repository.interfaces.RecipeKeywordRepository;
import com.mendix.recipe.repository.interfaces.RecipeRepository;
import com.mendix.recipe.service.interfaces.CategoryService;
import com.mendix.recipe.service.interfaces.RecipeService;
import com.mendix.recipe.util.XMLOperations;

import jakarta.persistence.EntityExistsException;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    RecipeMapper recipeMapper;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    RecipeCategoryRepository recipeCategoryRepository;

    @Autowired
    RecipeKeywordRepository recipeKeywordRepository;

    @Autowired
    CategoryService categoryService;

    @Override
    public List<RecipeDto> findAll() {
        return StreamSupport.stream(recipeRepository.findAll().spliterator(), false)
                .map(recipeMapper::recipeToRecipeDto).toList();
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
        recipe.getHead().getCategories().forEach(categoryService::save);
        recipeKeywordRepository.save(recipe.getHead().getTitle().toLowerCase(),
                recipe.getHead().getTitle().toLowerCase());
        recipe.getHead().getCategories().forEach(c -> {
            recipeCategoryRepository.save(c.getName().toLowerCase(), recipe.getHead().getTitle().toLowerCase());
            recipeKeywordRepository.save(c.getName().toLowerCase(), recipe.getHead().getTitle().toLowerCase());
        });
        recipe.getIngredients().getIngredients().stream().forEach(c -> {
            recipeKeywordRepository.save(c.getItem().toLowerCase(), recipe.getHead().getTitle().toLowerCase());
        });
        return recipeMapper.recipeToRecipeDto(recipeRepository.save(recipeMapper.recipeDtoToRecipe(recipe)));
    }

    @Override
    public List<RecipeDto> searchByKeyword(String keyword) {

        return List.of(recipeMapper
                .recipeToRecipeDto(recipeRepository.findById(recipeKeywordRepository.findByKeyword(keyword).get(0))));
        // return StreamSupport.stream(recipeRepository.findAll().spliterator(), false)
        // .filter(r -> r.toString().contains(keyword))
        // .map(recipeMapper::recipeToRecipeDto)
        // .toList();
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        XMLOperations.loadInitialFiles()
                .forEach(recipeXml -> save(recipeMapper.recipeToRecipeDto(recipeXml.getRecipe())));
    }

    private Boolean isExists(RecipeDto recipe) {
        return recipeRepository.existsById(recipe.getHead().getTitle().toLowerCase());
    }
}

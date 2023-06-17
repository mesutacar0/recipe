package com.mendix.recipe.service.implementations;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendix.recipe.dto.RecipeDto;
import com.mendix.recipe.exception.NoDataFoundException;
import com.mendix.recipe.mapper.RecipeMapper;
import com.mendix.recipe.model.Recipe;
import com.mendix.recipe.repository.interfaces.RecipeCategoryRepository;
import com.mendix.recipe.repository.interfaces.RecipeKeywordRepository;
import com.mendix.recipe.repository.interfaces.RecipeRepository;
import com.mendix.recipe.service.interfaces.CategoryService;
import com.mendix.recipe.service.interfaces.RecipeService;

import jakarta.persistence.EntityExistsException;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeMapper recipeMapper;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeCategoryRepository recipeCategoryRepository;

    @Autowired
    private RecipeKeywordRepository recipeKeywordRepository;

    @Autowired
    private CategoryService categoryService;

    @Override
    public List<RecipeDto> findAll() {
        return StreamSupport.stream(recipeRepository.findAll().spliterator(), false)
                .map(recipeMapper::recipeToRecipeDto).toList();
    }

    @Override
    public RecipeDto findByTitle(String title) {
        String recipeId = title.toLowerCase();
        if (!isExists(recipeId))
            throw new NoDataFoundException("Recipe Not Found wiht Title: " + title);

        return recipeMapper.recipeToRecipeDto(recipeRepository.findById(recipeId));
    }

    @Override
    public List<RecipeDto> findByCategory(String category) {
        return recipeCategoryRepository.findByCategory(category.toLowerCase()).stream()
                .map(recipeId -> recipeRepository.findById(recipeId))
                .filter(Objects::nonNull)
                .map(recipe -> recipeMapper.recipeToRecipeDto(recipe)).collect(Collectors.toList());
    }

    @Override
    public List<RecipeDto> searchByKeyword(String keyword) {
        return recipeKeywordRepository.findByKeyword(keyword.toLowerCase()).stream()
                .map(recipeId -> recipeRepository.findById(recipeId))
                .filter(Objects::nonNull)
                .map(recipe -> recipeMapper.recipeToRecipeDto(recipe)).collect(Collectors.toList());
    }

    @Override
    public synchronized RecipeDto save(RecipeDto recipeDto) {
        Recipe recipe = recipeMapper.recipeDtoToRecipe(recipeDto);
        if (isExists(recipe.getId()))
            throw new EntityExistsException();

        generateCategories(recipe);
        generateKeywords(recipe);

        return recipeMapper.recipeToRecipeDto(recipeRepository.save(recipe));
    }

    private boolean isExists(String recipeId) {
        return recipeRepository.existsById(recipeId);
    }

    private void generateKeywords(Recipe recipe) {
        Stream.of(recipe.getKeywords().replaceAll("[^A-Za-z ]", "").split(" "))
                .forEach(keyword -> recipeKeywordRepository.save(keyword, recipe.getId()));
    }

    private void generateCategories(Recipe recipe) {
        recipe.getHead().getCategories().forEach(categoryService::save);

        recipe.getHead().getCategories().forEach(category -> {
            recipeCategoryRepository.save(category.getId(), recipe.getId());
        });
    }

    @Override
    public void deleteAll() {
        recipeRepository.deleteAll();
        recipeCategoryRepository.deleteAll();
        recipeKeywordRepository.deleteAll();
    }
}

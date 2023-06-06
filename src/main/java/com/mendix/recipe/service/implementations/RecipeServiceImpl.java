package com.mendix.recipe.service.implementations;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.mendix.recipe.config.ApplicationConfig;
import com.mendix.recipe.dto.RecipeDto;
import com.mendix.recipe.exception.NoDataFoundException;
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

    @Autowired
    private ApplicationConfig applicationConfig;

    @Override
    public List<RecipeDto> findAll() {
        return StreamSupport.stream(recipeRepository.findAll().spliterator(), false)
                .map(recipeMapper::recipeToRecipeDto).toList();
    }

    @Override
    public List<RecipeDto> findByCategory(String category) {
        return recipeCategoryRepository.findByCategory(category).stream().map(id -> recipeRepository.findById(id))
                .filter(x -> x != null)
                .map(r -> recipeMapper.recipeToRecipeDto(r)).collect(Collectors.toList());
    }

    @Override
    public RecipeDto save(RecipeDto recipe) {
        if (isExists(recipe.getHead().getTitle().toString().toLowerCase()))
            throw new EntityExistsException();

        generateCategories(recipe);
        generateKeywords(recipe);

        return recipeMapper.recipeToRecipeDto(recipeRepository.save(recipeMapper.recipeDtoToRecipe(recipe)));
    }

    @Override
    public List<RecipeDto> searchByKeyword(String keyword) {
        return recipeKeywordRepository.findByKeyword(keyword).stream().map(id -> recipeRepository.findById(id))
                .filter(x -> x != null)
                .map(r -> recipeMapper.recipeToRecipeDto(r)).collect(Collectors.toList());
    }

    @Override
    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        XMLOperations.loadInitialFiles(applicationConfig.getXmlFilePath())
                .forEach(recipeXml -> save(recipeMapper.recipeToRecipeDto(recipeXml.getRecipe())));
    }

    private Boolean isExists(String recipeId) {
        return recipeRepository.existsById(recipeId);
    }

    private void generateKeywords(RecipeDto recipe) {
        Stream.of(recipe.getKeywords().split(" "))
                .forEach(s -> recipeKeywordRepository.save(s, recipe.getHead().getTitle().toLowerCase()));
    }

    private void generateCategories(RecipeDto recipe) {
        recipe.getHead().getCategories().forEach(categoryService::save);

        recipe.getHead().getCategories().forEach(c -> {
            recipeCategoryRepository.save(c.getName().toLowerCase(), recipe.getHead().getTitle().toLowerCase());
        });
    }

    @Override
    public RecipeDto findByTitle(String title) {
        String recipeId = title.toLowerCase();
        if (!isExists(recipeId))
            throw new NoDataFoundException("Recipe Not Found: " + title);

        return recipeMapper.recipeToRecipeDto(recipeRepository.findById(recipeId));
    }
}

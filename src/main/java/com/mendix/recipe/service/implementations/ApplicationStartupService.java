package com.mendix.recipe.service.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.mendix.recipe.config.ApplicationConfig;
import com.mendix.recipe.mapper.RecipeMapper;
import com.mendix.recipe.service.interfaces.RecipeService;
import com.mendix.recipe.util.XMLOperations;

@Service
public class ApplicationStartupService {

    @Autowired
    private ApplicationConfig applicationConfig;

    @Autowired
    private RecipeMapper recipeMapper;

    @Autowired
    private RecipeService recipeService;

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        XMLOperations.loadInitialFiles(applicationConfig.getXmlFilePath())
                .forEach(recipeXml -> recipeService.save(recipeMapper.recipeToRecipeDto(recipeXml.getRecipe())));
    }
}

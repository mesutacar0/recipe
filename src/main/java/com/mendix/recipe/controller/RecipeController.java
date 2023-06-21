package com.mendix.recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mendix.recipe.dto.RecipeDto;
import com.mendix.recipe.service.interfaces.RecipeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/recipes")
@Tag(name = "Recipes", description = "API of the Recipes")
public class RecipeController {

        @Autowired
        RecipeService recipeService;

        @Operation(summary = "List of Recipes", description = "Get List of All Available Recipes")
        @ApiResponse(responseCode = "200", content = {
                        @Content(schema = @Schema(implementation = RecipeDto.class)) })
        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })
        @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<RecipeDto>> get(
                        @Parameter(name = "keyword", in = ParameterIn.QUERY, description = "Search for recipes for specified keyword(case insensitive)") @RequestParam(name = "keyword", required = false) String keyword,
                        @Parameter(name = "category", in = ParameterIn.QUERY, description = "List of recipes by category(case insensitive)") @RequestParam(name = "category", required = false) String category) {
                List<RecipeDto> recipes;

                if (category != null)
                        recipes = recipeService.findByCategory(category);
                else if (keyword != null)
                        recipes = recipeService.searchByKeyword(keyword);
                else
                        recipes = recipeService.findAll();

                return new ResponseEntity<>(recipes, HttpStatus.OK);
        }

        @Operation(summary = "Recipe by Title", description = "Get the Recipe by Title if exists")
        @ApiResponse(responseCode = "200", content = {
                        @Content(schema = @Schema(implementation = RecipeDto.class)) })
        @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) })
        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })
        @GetMapping(path = "{title}", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<RecipeDto> getByTitle(
                        @Parameter(name = "title", in = ParameterIn.PATH, required = true, description = "Search for recipe for specified title(case insensitive)") @PathVariable("title") @NotEmpty String title) {
                RecipeDto recipes = recipeService.findByTitle(title);
                return new ResponseEntity<>(recipes, HttpStatus.OK);
        }

        @Operation(summary = "New Recipe", description = "Post a new Recipe")
        @ApiResponse(responseCode = "201", content = {
                        @Content(schema = @Schema(implementation = RecipeDto.class)) })
        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })
        @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema()) })
        @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<RecipeDto> create(@Valid @RequestBody RecipeDto newRecipe) {
                RecipeDto recipe = recipeService.save(newRecipe);
                return new ResponseEntity<>(recipe, HttpStatus.CREATED);
        }
}

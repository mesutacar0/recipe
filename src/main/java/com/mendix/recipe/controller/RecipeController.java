package com.mendix.recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mendix.recipe.dto.RecipeDto;
import com.mendix.recipe.service.interfaces.RecipeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/recipes")
@Tag(name = "Recipes", description = "API of the Recipes")
public class RecipeController {

        @Autowired
        RecipeService recipeService;

        @Operation(summary = "List of Recipes", description = "Get List of All Available Recipes")
        @ApiResponses({
                        @ApiResponse(responseCode = "200", content = {
                                        @Content(schema = @Schema(implementation = RecipeDto.class)) }),
                        @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
        @GetMapping()
        public ResponseEntity<List<RecipeDto>> get() {
                List<RecipeDto> recipes = recipeService.findAll();
                return new ResponseEntity<>(recipes, HttpStatus.OK);
        }

        @Operation(summary = "List of Recipes by Category", description = "Get List of Recipes for specified Category")
        @ApiResponses({
                        @ApiResponse(responseCode = "200", content = {
                                        @Content(schema = @Schema(implementation = RecipeDto.class)) }),
                        @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
        @GetMapping("/category")
        public ResponseEntity<List<RecipeDto>> getByCategory(@RequestParam("category") @NotEmpty String category) {
                List<RecipeDto> recipes = recipeService.findByCategory(category);
                return new ResponseEntity<>(recipes, HttpStatus.OK);
        }

        @Operation(summary = "Recipes by Title", description = "Get the Recipe by Title if exists")
        @ApiResponses({
                        @ApiResponse(responseCode = "200", content = {
                                        @Content(schema = @Schema(implementation = RecipeDto.class)) }),
                        @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
        @GetMapping("/title")
        public ResponseEntity<RecipeDto> getByTitle(@RequestParam("title") @NotEmpty String title) {
                RecipeDto recipes = recipeService.findByTitle(title);
                return new ResponseEntity<>(recipes, HttpStatus.OK);
        }

        @Operation(summary = "List of Recipes by Keyword", description = "Get List of Recipes for specified Keyword")
        @ApiResponses({
                        @ApiResponse(responseCode = "200", content = {
                                        @Content(schema = @Schema(implementation = RecipeDto.class)) }),
                        @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
        @GetMapping("/search")
        public ResponseEntity<List<RecipeDto>> get(@RequestParam("keyword") @NotEmpty String keyword) {
                List<RecipeDto> recipes = recipeService.searchByKeyword(keyword);
                return new ResponseEntity<>(recipes, HttpStatus.OK);
        }

        @Operation(summary = "New Recipe", description = "Post a new Recipe")
        @ApiResponses({
                        @ApiResponse(responseCode = "201", content = {
                                        @Content(schema = @Schema(implementation = RecipeDto.class)) }),
                        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema()) }) })
        @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<RecipeDto> create(@Validated @RequestBody RecipeDto newRecipe) {
                RecipeDto recipe = recipeService.save(newRecipe);
                return new ResponseEntity<>(recipe, HttpStatus.CREATED);
        }
}

package com.mendix.recipe.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mendix.recipe.dto.CategoryDto;
import com.mendix.recipe.service.interfaces.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/category")
@Tag(name = "Recipe Categories", description = "API of the Recipe Categories")
public class CategoryController {

        @Autowired
        CategoryService categoryService;

        @Operation(summary = "List of Categories", description = "Get List of All Available Recipe Categories")
        @ApiResponses({
                        @ApiResponse(responseCode = "200", content = {
                                        @Content(schema = @Schema(implementation = CategoryDto.class)) }),
                        @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
        @GetMapping("/")
        public ResponseEntity<Set<CategoryDto>> get() {
                Set<CategoryDto> categoryDtos = categoryService.findAll();
                return new ResponseEntity<>(categoryDtos, HttpStatus.OK);
        }

        @Operation(summary = "New Category", description = "Put a new Category")
        @ApiResponses({
                        @ApiResponse(responseCode = "201", content = {
                                        @Content(schema = @Schema(implementation = CategoryDto.class)) }),
                        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }),
                        @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }) })
        @PutMapping("/")
        public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto definition) {
                categoryService.save(definition);
                return new ResponseEntity<>(definition, HttpStatus.CREATED);
        }
}

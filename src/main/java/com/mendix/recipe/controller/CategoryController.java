package com.mendix.recipe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mendix.recipe.dto.CategoryDto;
import com.mendix.recipe.service.interfaces.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/categories")
@Tag(name = "Recipe Categories", description = "API of the Recipe Categories")
public class CategoryController {

        @Autowired
        CategoryService categoryService;

        @Operation(summary = "List of Categories", description = "Get List of All Available Recipe Categories")
        @ApiResponse(responseCode = "200", content = {
                        @Content(schema = @Schema(implementation = CategoryDto.class)) })
        @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) })
        @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<CategoryDto>> get() {
                List<CategoryDto> categoryDtos = categoryService.findAll();
                return new ResponseEntity<>(categoryDtos, HttpStatus.OK);
        }
}

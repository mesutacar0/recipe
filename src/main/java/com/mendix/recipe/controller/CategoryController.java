package com.mendix.recipe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mendix.recipe.dto.CategoryDto;

@RestController
public class CategoryController {

    @GetMapping("/category")
    public ResponseEntity<List<CategoryDto>> get() {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        return new ResponseEntity<List<CategoryDto>>(categoryDtos, HttpStatus.OK);
    }

    @PutMapping("/category")
    public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto definition) {
        return new ResponseEntity<>(definition, HttpStatus.CREATED);
    }
}

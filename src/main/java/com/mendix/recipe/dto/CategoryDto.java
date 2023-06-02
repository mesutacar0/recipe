package com.mendix.recipe.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Category Model Information")
public class CategoryDto {

    @Schema(description = "Category's name", example = "Microwave")
    private String name;
}

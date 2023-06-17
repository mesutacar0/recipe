package com.mendix.recipe.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;

@Schema(name = "Category", description = "Category Model Information")
public class CategoryDto {

    @Schema(description = "Category's name", example = "Microwave")
    @NotEmpty(message = "Category name is mandatory")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

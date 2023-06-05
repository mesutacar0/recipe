package com.mendix.recipe.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

@Schema(description = "Category Model Information")
public class CategoryDto {

    @Schema(description = "Category's name", example = "Microwave")
    @NotBlank
    @NotEmpty
    @JsonProperty(required = true)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryDto(String name) {
        this.name = name;
    }

    public CategoryDto() {
    }
}

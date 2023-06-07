package com.mendix.recipe.dto;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        CategoryDto other = (CategoryDto) obj;

        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.toLowerCase().equals(other.name.toLowerCase())) {
            return false;
        }
        return true;
    }

}

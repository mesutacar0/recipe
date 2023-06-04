package com.mendix.recipe.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Category Model Information")
public class CategoryDto {

    @Schema(description = "Category's name", example = "Microwave")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final CategoryDto other = (CategoryDto) obj;
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    /**
     * @param name
     */
    public CategoryDto(String name) {
        this.name = name;
    }
}

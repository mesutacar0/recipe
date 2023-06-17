package com.mendix.recipe.dto;

import java.util.Objects;

import com.mendix.recipe.dto.validation.IngredientWrapperValidation;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

@Schema(name = "Recipe", description = "Recipe Model Information")
public class RecipeDto {

    @NotNull(message = "Recipe Head info cannot be null")
    @Valid
    private RecipeHeadDto head;
    @IngredientWrapperValidation
    @Valid
    private IngredientWrapperDto ingredients;
    @NotNull(message = "Recipe Directions cannot be empty")
    @Valid
    private DirectionDto directions;

    public RecipeHeadDto getHead() {
        return head;
    }

    public void setHead(RecipeHeadDto head) {
        this.head = head;
    }

    public DirectionDto getDirections() {
        return directions;
    }

    public void setDirections(DirectionDto directions) {
        this.directions = directions;
    }

    public IngredientWrapperDto getIngredients() {
        return ingredients;
    }

    public void setIngredients(IngredientWrapperDto ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public int hashCode() {
        return Objects.hash(head.getTitle().toLowerCase());
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
        RecipeDto other = (RecipeDto) obj;
        return Objects.equals(head.getTitle().toLowerCase(), other.getHead().getTitle().toLowerCase());
    }
}

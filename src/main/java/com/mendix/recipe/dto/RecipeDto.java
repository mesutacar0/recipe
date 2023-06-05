package com.mendix.recipe.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Recipe Model Information")
public class RecipeDto {

    private RecipeHeadDto head;
    private IngredientWrapperDto ingredients;
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

    public RecipeDto() {
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((head.getTitle() == null) ? 0 : head.getTitle().hashCode());
        return result;
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

        if (head.getTitle() == null) {
            if (other.head.getTitle() != null) {
                return false;
            }
        } else if (!head.getTitle().equals(other.head.getTitle())) {
            return false;
        }
        return true;
    }

    public IngredientWrapperDto getIngredients() {
        return ingredients;
    }

    public void setIngredients(IngredientWrapperDto ingredients) {
        this.ingredients = ingredients;
    }
}

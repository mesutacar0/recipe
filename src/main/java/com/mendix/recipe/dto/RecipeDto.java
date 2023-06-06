package com.mendix.recipe.dto;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Recipe Model Information")
public class RecipeDto {
    @NotNull
    private RecipeHeadDto head;
    @NotNull
    private IngredientWrapperDto ingredients;
    @NotNull
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
        return Objects.hash(head.getTitle());
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

        return Objects.equals(head.getTitle(), other.getHead().getTitle());
    }

    public IngredientWrapperDto getIngredients() {
        return ingredients;
    }

    public void setIngredients(IngredientWrapperDto ingredients) {
        this.ingredients = ingredients;
    }

    public String getKeywords() {
        StringBuilder keywords = new StringBuilder();
        keywords.append(head.getTitle()).append(" ");
        head.getCategories().forEach(c -> keywords.append(c.getName()).append(" "));
        keywords.append(
                ingredients.getIngredients().stream().map(IngredientDto::getItem).collect(Collectors.joining(" ")));
        keywords.append(ingredients.getIngredientDivs().stream().map(IngredientDivisionDto::getIngredients)
                .flatMap(Collection::stream).map(IngredientDto::getItem).collect(Collectors.joining(" ")));

        return keywords.toString().toLowerCase();
    }
}

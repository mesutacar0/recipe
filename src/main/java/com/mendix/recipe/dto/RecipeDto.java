package com.mendix.recipe.dto;

import java.util.Objects;

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
        StringBuffer keywords = new StringBuffer();
        keywords.append(head.getTitle());
        head.getCategories().forEach(c -> keywords.append(c.getName()));

        if (ingredients.getIngredients() != null && !ingredients.getIngredients().isEmpty())
            ingredients.getIngredients().forEach(i -> keywords.append(i.getItem()));

        if (ingredients.getIngredientDivs() != null && !ingredients.getIngredientDivs().isEmpty())
            ingredients.getIngredientDivs()
                    .forEach(div -> div.getIngredients().forEach(i -> keywords.append(i.getItem())));

        return keywords.toString().toLowerCase();
    }
}

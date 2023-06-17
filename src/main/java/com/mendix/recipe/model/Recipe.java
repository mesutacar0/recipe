package com.mendix.recipe.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

@XmlRootElement(name = "recipe")
public class Recipe {

    private RecipeHead head;
    private IngredientWrapper ingredients;
    private Direction directions;
    private String id;

    public RecipeHead getHead() {
        return head;
    }

    public void setHead(RecipeHead head) {
        this.head = head;
        this.id = head.getTitle().toLowerCase();
    }

    public Direction getDirections() {
        return directions;
    }

    public void setDirections(Direction directions) {
        this.directions = directions;
    }

    public IngredientWrapper getIngredients() {
        return ingredients;
    }

    public void setIngredients(IngredientWrapper ingredients) {
        this.ingredients = ingredients;
    }

    @XmlTransient
    public String getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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
        Recipe other = (Recipe) obj;
        return Objects.equals(id, other.getId());
    }

    public String getKeywords() {
        StringBuilder keywords = new StringBuilder();
        keywords.append(head.getTitle()).append(" ");
        head.getCategories().forEach(category -> keywords.append(category.getName()).append(" "));
        keywords.append(
                ingredients.getIngredients().stream().map(Ingredient::getItem).collect(Collectors.joining(" ")));
        keywords.append(ingredients.getIngredientDivs().stream().map(IngredientDivision::getIngredients)
                .flatMap(Collection::stream).map(Ingredient::getItem).collect(Collectors.joining(" ")));

        return keywords.toString().toLowerCase();
    }
}

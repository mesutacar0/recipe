package com.mendix.recipe.model;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlAccessType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "recipeml", namespace = "")
public class RecipeXML {

    @XmlAttribute
    private String version;
    private Recipe recipe;

    /**
     * @return the recipe
     */
    public Recipe getRecipe() {
        return recipe;
    }

    /**
     * @param recipe the recipe to set
     */
    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

}

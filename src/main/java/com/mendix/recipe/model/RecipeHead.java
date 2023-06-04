package com.mendix.recipe.model;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "head")
public class RecipeHead {
    @XmlElement(name = "title")
    private String title;
    @XmlElementWrapper(name = "categories")
    @XmlElement(name = "cat")
    private List<Category> categories;
    @XmlElement(name = "yield")
    private int yield;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public int getYield() {
        return yield;
    }

    public void setYield(int yield) {
        this.yield = yield;
    }

    public RecipeHead(String title, List<Category> categories, int yield) {
        this.title = title;
        this.categories = categories;
        this.yield = yield;
    }

    public RecipeHead() {
    }

}

package com.mendix.recipe.model;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "head")
public class RecipeHead {
    private String title;
    private List<Category> categories;
    private int yield;

    @XmlElement(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElementWrapper(name = "categories")
    @XmlElement(name = "cat")
    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @XmlElement(name = "yield")
    public int getYield() {
        return yield;
    }

    public void setYield(int yield) {
        this.yield = yield;
    }
}

package com.mendix.recipe.model;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlAccessType;

@XmlRootElement(name = "head")
@XmlAccessorType(XmlAccessType.FIELD)
public class RecipeHead {
    @XmlElement(name = "title")
    private String title;
    @XmlElementWrapper(name = "categories")
    @XmlElement(name = "cat")
    private List<String> categories;
    @XmlElement(name = "yield")
    private int yield;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public int getYield() {
        return yield;
    }

    public void setYield(int yield) {
        this.yield = yield;
    }

    public RecipeHead(String title, List<String> categories, int yield) {
        this.title = title;
        this.categories = categories;
        this.yield = yield;
    }

    public RecipeHead() {
    }
}

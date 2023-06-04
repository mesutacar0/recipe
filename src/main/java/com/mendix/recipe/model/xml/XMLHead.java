package com.mendix.recipe.model.xml;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class XMLHead {
    private String title;
    private int yield;
    private List<String> categories;

    @XmlElement(name = "title")
    public void setTitle(String title) {
        this.title = title;
    }

    @XmlElement(name = "yield")
    public void setYield(int yield) {
        this.yield = yield;
    }

    @XmlElement(name = "categories")
    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

}

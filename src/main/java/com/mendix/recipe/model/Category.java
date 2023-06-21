package com.mendix.recipe.model;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
import jakarta.xml.bind.annotation.XmlValue;

import java.util.Objects;

@XmlRootElement(name = "cat")
public class Category {

    private String name;
    private String id;

    @XmlValue
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        this.id = name.toLowerCase();
    }

    @XmlTransient
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
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
        Category other = (Category) obj;
        return Objects.equals(id, other.getId());
    }
}

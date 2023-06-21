package com.mendix.recipe.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "directions")
public class Direction {

    private String step;

    @XmlElement(name = "step")
    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

}

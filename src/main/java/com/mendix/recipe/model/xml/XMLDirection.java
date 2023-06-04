package com.mendix.recipe.model.xml;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "directions")
public class XMLDirection {
    @XmlElement(name = "step")
    private String step;

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

}

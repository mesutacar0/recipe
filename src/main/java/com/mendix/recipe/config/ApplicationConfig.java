package com.mendix.recipe.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Value("${recipe.app.xmlFilePath}")
    private String xmlFilePath;

    public String getXmlFilePath() {
        return xmlFilePath;
    }
}

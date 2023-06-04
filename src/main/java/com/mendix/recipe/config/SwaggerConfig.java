package com.mendix.recipe.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Value("${swagger.contact.name}")
    private String name;
    @Value("${swagger.contact.email}")
    private String email;
    @Value("${swagger.contact.url}")
    private String url;

    @Bean
    public OpenAPI myOpenAPI() {

        Contact contact = new Contact();
        contact.setEmail(email);
        contact.setName(name);
        contact.setUrl(url);

        Info info = new Info()
                .title("Mendix Recipe API")
                .version("1.0.0")
                .contact(contact)
                .description("This API exposes endpoints to manage recipes.");

        return new OpenAPI().info(info);
    }
}

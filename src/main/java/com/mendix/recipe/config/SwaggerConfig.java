package com.mendix.recipe.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

    @Value("${swagger.url}")
    private String devUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server server = new Server();
        server.setUrl(devUrl);
        server.setDescription("Server URL in Development environment");

        Contact contact = new Contact();
        contact.setEmail("mesutacar0@gmail.com");
        contact.setName("Mesut Acar");
        contact.setUrl("https://github.com/mesutacar0");

        Info info = new Info()
                .title("Mendix Recipe API")
                .version("0.0.1")
                .contact(contact)
                .description("This API exposes endpoints to manage recipes.");

        return new OpenAPI().info(info).servers(List.of(server));
    }
}

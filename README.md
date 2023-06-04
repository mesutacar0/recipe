# Spring Boot Recipe API

BeckEnd Rest Service for Recipes


## Requirements

For building and running the application you need;
- JDK 17
- Maven
- Spring Boot 3


## Building and Running

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.mendix.recipe.RecipeApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Usage

Application will initially look for xml files on path specified at application.properties recipe.app.xmlFilePath tag.

After building and running the application locally at 8080 port; available endpoints and model with documentations will be accessed and can be tested on;

[Swagger UI](http://localhost:8080/swagger-ui/index.html#/)

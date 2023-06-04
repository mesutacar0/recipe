package com.mendix.recipe.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.mendix.recipe.model.RecipeXML;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public final class XMLOperations {

    @Value("${recipe.app.xmlFilePath}")
    private static String path;

    public static RecipeXML unmarshal(FileReader file) throws JAXBException {

        JAXBContext context;
        Unmarshaller unmarshaller;

        context = JAXBContext.newInstance(RecipeXML.class);
        unmarshaller = context.createUnmarshaller();
        unmarshaller.setEventHandler(new XMLValidationEventHandler());
        RecipeXML recipeXML = (RecipeXML) unmarshaller
                .unmarshal(file);

        return recipeXML;
    }

    public static void marshal(RecipeXML recipeXML) throws JAXBException {

        JAXBContext context;
        Marshaller marshaller;

        context = JAXBContext.newInstance(RecipeXML.class);
        marshaller = context.createMarshaller();
        marshaller.setEventHandler(new XMLValidationEventHandler());
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(recipeXML, new File(path + recipeXML.getRecipe().getHead().getTitle() + ".xml"));
    }

    public static Boolean isXmlFile(File file) {
        Boolean isXml = false;
        try {
            String content = Files.probeContentType(file.toPath());
            isXml = content.contains("xml");
        } catch (IOException e) {
            isXml = false;
        }
        return isXml;
    }

    public static List<RecipeXML> loadInitialFiles() {

        List<RecipeXML> recipes = new ArrayList<>();

        System.out.println(path);

        final File folder = new File("Z:/oth/mx/api/recipe/src/main/resources/xml/");
        final List<File> fileList = Arrays.asList(folder.listFiles());

        fileList.stream().filter(XMLOperations::isXmlFile).forEach(xmlFile -> {
            try (FileReader fileReader = new FileReader(xmlFile)) {
                recipes.add(unmarshal(fileReader));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return recipes;
    }
}

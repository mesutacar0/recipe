package com.mendix.recipe.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import com.mendix.recipe.model.RecipeML;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public final class XMLOperations {

    @Value("${recipe.app.xmlFilePath}")
    private static String path;

    private final static Logger logger = LoggerFactory.getLogger(XMLOperations.class);

    public static RecipeML unmarshal(FileReader file) throws JAXBException {

        JAXBContext context;
        Unmarshaller unmarshaller;

        context = JAXBContext.newInstance(RecipeML.class);
        unmarshaller = context.createUnmarshaller();
        unmarshaller.setEventHandler(new XMLValidationEventHandler());
        RecipeML recipeML = (RecipeML) unmarshaller
                .unmarshal(file);

        logger.info("XML File Unmarshalled: " + file.toString());
        return recipeML;
    }

    public static void marshal(RecipeML recipeXML) throws JAXBException {

        JAXBContext context;
        Marshaller marshaller;

        context = JAXBContext.newInstance(RecipeML.class);
        marshaller = context.createMarshaller();
        marshaller.setEventHandler(new XMLValidationEventHandler());
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(recipeXML, new File(path + recipeXML.getRecipe().getHead().getTitle() + ".xml"));
    }

    public static Boolean isXmlFile(File file) {
        Boolean isXml = false;
        try {
            String content = Files.probeContentType(file.toPath());
            if (content.contains("xml")) {
                isXml = true;
            } else {
                logger.info("Invalid File Type Failed: " + content);
            }
        } catch (IOException e) {
            logger.info("File Content Type Failed: " + e.getMessage());
            isXml = false;
        }
        return isXml;
    }

    public static List<RecipeML> loadInitialFiles() {

        List<RecipeML> recipeMls = new ArrayList<>();

        System.out.println(path);

        final File folder = new File("Z:/oth/mx/api/recipe/src/main/resources/xml/");
        final List<File> fileList = Arrays.asList(folder.listFiles());

        fileList.stream().filter(XMLOperations::isXmlFile).forEach(xmlFile -> {
            try (FileReader fileReader = new FileReader(xmlFile)) {
                recipeMls.add(unmarshal(fileReader));
            } catch (Exception e) {
                logger.info("Loading file failed: " + e.getMessage());
            }
        });
        return recipeMls;
    }
}

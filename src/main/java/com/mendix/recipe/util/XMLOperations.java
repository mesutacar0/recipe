package com.mendix.recipe.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mendix.recipe.model.RecipeML;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;

public final class XMLOperations {

    private final static Logger logger = LoggerFactory.getLogger(XMLOperations.class);

    public static RecipeML unmarshal(File file) {

        RecipeML recipeML = null;

        try (FileReader fileReader = new FileReader(file)) {
            JAXBContext context = JAXBContext.newInstance(RecipeML.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            unmarshaller.setEventHandler(new XMLValidationEventHandler());

            recipeML = (RecipeML) unmarshaller.unmarshal(file);
        } catch (Exception e) {
            logger.info("Loading file failed: {}", file.getPath());
        }

        logger.info("XML File Unmarshalled: " + file.toString());
        return recipeML;
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
        }
        return isXml;
    }

    public static List<RecipeML> loadInitialFiles(String xmlFilePath) {
        final File folder = new File(xmlFilePath);
        return Stream.of(folder.listFiles())//
                .filter(XMLOperations::isXmlFile).map(XMLOperations::unmarshal)
                .filter(x -> x != null).collect(Collectors.toList());
    }
}

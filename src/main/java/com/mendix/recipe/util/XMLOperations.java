package com.mendix.recipe.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import com.mendix.recipe.model.RecipeML;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public final class XMLOperations {

    private static final Logger logger = LoggerFactory.getLogger(XMLOperations.class);

    private static RecipeML unmarshal(File file) {
        RecipeML recipeML = null;
        try (FileReader fileReader = new FileReader(file)) {
            JAXBContext context = JAXBContext.newInstance(RecipeML.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            unmarshaller.setEventHandler(new XMLValidationEventHandler());

            recipeML = (RecipeML) unmarshaller.unmarshal(fileReader);
            logger.info("XML File Unmarshalled: {}", file);
        } catch (JAXBException | IOException e) {
            logger.info("Loading file Failed: {}  {}", file.getPath(), e.getMessage());
        }
        return recipeML;
    }

    private static Boolean isXmlFile(File file) {
        Boolean isXml = false;
        try {
            String content = Files.probeContentType(file.toPath());
            if (content.contains("xml")) {
                isXml = true;
            } else {
                logger.info("Invalid File Type Failed: {}", content);
            }
        } catch (IOException e) {
            logger.info("File Content Type Failed: {}", e.getMessage());
        }
        return isXml;
    }

    public static List<RecipeML> loadInitialFiles(String xmlFilePath) {
        try {
            File folder = ResourceUtils.getFile(xmlFilePath);

            return Stream.of(folder.listFiles())
                    .filter(XMLOperations::isXmlFile).map(XMLOperations::unmarshal)
                    .filter(Objects::nonNull).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            logger.info("Initial file loading Failed: {}", e.getMessage());
        }
        return Collections.emptyList();
    }
}

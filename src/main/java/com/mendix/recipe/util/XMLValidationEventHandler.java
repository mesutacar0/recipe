package com.mendix.recipe.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.xml.bind.ValidationEvent;
import jakarta.xml.bind.ValidationEventHandler;

public class XMLValidationEventHandler implements ValidationEventHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean handleEvent(ValidationEvent event) {
        logger.info("XML Validation Event Info: " + event);
        if (event.getMessage().toLowerCase().contains("unexpected element"))
            return true;
        return false;
    }
}

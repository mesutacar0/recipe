package com.mendix.recipe.util;

import jakarta.xml.bind.ValidationEvent;
import jakarta.xml.bind.ValidationEventHandler;

public class XMLValidationEventHandler implements ValidationEventHandler {

    @Override
    public boolean handleEvent(ValidationEvent event) {
        System.out.println("Event Info: " + event);
        if (event.getMessage().toLowerCase().contains("unexpected element"))
            return true;
        return false;
    }

}

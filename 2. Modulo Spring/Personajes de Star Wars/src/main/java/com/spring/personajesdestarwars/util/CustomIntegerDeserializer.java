package com.spring.personajesdestarwars.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class CustomIntegerDeserializer extends JsonDeserializer<Integer> {
    @Override
    public Integer deserialize(JsonParser jsonParser, DeserializationContext context)
            throws IOException {
        String value = jsonParser.getText();
        if ("NA".equals(value) || value == null || value.isEmpty()) {
            return null;
        }
        value = value.replace(",", "");

        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}


package com.example.starwars.deserializer;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class CustomIntegerDeserializer extends JsonDeserializer<Integer> {

    @Override
    public Integer deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        String value = jp.getText();
        if ("NA".equals(value)) {
            return null;
        }
        try {
            // Eliminar comas y convertir a Integer
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
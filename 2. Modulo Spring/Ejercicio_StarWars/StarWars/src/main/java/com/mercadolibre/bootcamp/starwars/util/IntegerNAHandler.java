package com.mercadolibre.bootcamp.starwars.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class IntegerNAHandler extends JsonDeserializer<Integer> {

    @Override
    public Integer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String text = p.getText();
        if ("NA".equalsIgnoreCase(text)) {
            return null;
        }
        try {
            return Integer.valueOf(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
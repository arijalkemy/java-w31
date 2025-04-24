package com.fernandotorres.multicapa.entity;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class SafeIntDeserializer extends JsonDeserializer<Integer> {
    @Override
    public Integer deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        try {
            String value = p.getText();
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return -1; // valor por defecto si viene "NA" o algo no numérico
        }
    }
}
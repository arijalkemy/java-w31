package com.bootcamp.ejercicio_starwars.util;

public class JsonDeserializer{
    public static Integer parseInteger(String value) {
        try {
            return Integer.valueOf(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}

package com.mercadolibre.groupfive.socialmeli.util;

import java.io.Serializable;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.Serializable;

public class UtilTest {
    private static final ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.registerModule(new JavaTimeModule());
    }

    private UtilTest() {
    }

    public static <T> T generateFromJson(String data, Class<T> classType) throws JsonProcessingException {
        return mapper.readValue(data, classType);
    }

    public static String generateFromList(List<Integer> list) throws Exception {
        return mapper.writeValueAsString(list);
    }

    public static String generateFromDto(Serializable dto) throws Exception {
        return mapper.writeValueAsString(dto);
    }
}

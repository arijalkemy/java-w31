package com.mercadolibre.qatesters.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.qatesters.dto.TestCaseDto;
import com.mercadolibre.qatesters.model.TestCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.databind.SerializationFeature;

public class MapperUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    public static TestCaseDto toDto(TestCase jewel) {
        if (jewel == null) return null;
        return objectMapper.convertValue(jewel, TestCaseDto.class);
    }

    public static TestCase toEntity(TestCaseDto dto) {
        if (dto == null) return null;
        return objectMapper.convertValue(dto, TestCase.class);
    }
}

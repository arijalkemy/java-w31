package com.mercadolibre.showroom.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.showroom.dto.ClothingItemDto;
import com.mercadolibre.showroom.model.ClothingItem;

public class MapperUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    public static <T> T toDto(Object entity, Class<T> dtoClass) {
        if (entity == null) return null;
        return objectMapper.convertValue(entity, dtoClass);
    }

    // Convierte de DTO a entidad
    public static <T> T toEntity(Object dto, Class<T> entityClass) {
        if (dto == null) return null;
        return objectMapper.convertValue(dto, entityClass);
    }
}

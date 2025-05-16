package com.meli.jewelry.app.utils;

import com.meli.jewelry.app.dto.JewelDto;
import com.meli.jewelry.app.model.Jewel;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MapperUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static JewelDto toDto(Jewel jewel) {
        if (jewel == null) return null;
        return objectMapper.convertValue(jewel, JewelDto.class);
    }

    public static Jewel toEntity(JewelDto dto) {
        if (dto == null) return null;
        return objectMapper.convertValue(dto, Jewel.class);
    }
}

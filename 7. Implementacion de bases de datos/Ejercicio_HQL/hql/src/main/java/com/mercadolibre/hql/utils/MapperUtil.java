package com.mercadolibre.hql.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.hql.dto.VehicleDto;
import com.mercadolibre.hql.model.Vehicle;

public class MapperUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    public static VehicleDto toDto(Vehicle vehicle) {
        if (vehicle == null) return null;
        return objectMapper.convertValue(vehicle, VehicleDto.class);
    }

    public static Vehicle toEntity(VehicleDto dto) {
        if (dto == null) return null;
        return objectMapper.convertValue(dto, Vehicle.class);
    }
}

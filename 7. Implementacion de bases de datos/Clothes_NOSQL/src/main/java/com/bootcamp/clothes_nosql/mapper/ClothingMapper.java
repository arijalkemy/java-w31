package com.bootcamp.clothes_nosql.mapper;

import com.bootcamp.clothes_nosql.dto.ClothingDTO;
import com.bootcamp.clothes_nosql.model.Clothing;

public class ClothingMapper {

    public static ClothingDTO toDTO(Clothing entity) {
        return new ClothingDTO(
                entity.getCode(),
                entity.getName(),
                entity.getType(),
                entity.getBrand(),
                entity.getColor(),
                entity.getSize(),
                entity.getQuantity(),
                entity.getSalePrice()
        );
    }

    public static Clothing toEntity(ClothingDTO dto) {
        return new Clothing(
                dto.getCode(),
                dto.getName(),
                dto.getType(),
                dto.getBrand(),
                dto.getColor(),
                dto.getSize(),
                dto.getQuantity(),
                dto.getSalePrice()
        );
    }
}


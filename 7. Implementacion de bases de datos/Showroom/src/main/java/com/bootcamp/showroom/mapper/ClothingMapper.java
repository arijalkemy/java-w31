package com.bootcamp.showroom.mapper;

import com.bootcamp.showroom.dto.ClothingDTO;
import com.bootcamp.showroom.model.Clothing;

public class ClothingMapper {
    public static ClothingDTO toDTO(Clothing c){
        return new ClothingDTO(c.getCode(), c.getName(), c.getType(), c.getBrand(), c.getColor(), c.getSize(), c.getQuantity(), c.getSalePrice());
    }

    public static Clothing toEntity(ClothingDTO dto) {
        return new Clothing(dto.getCode(), dto.getName(), dto.getType(), dto.getBrand(), dto.getColor(), dto.getSize(), dto.getQuantity(), dto.getSalePrice());
    }

}

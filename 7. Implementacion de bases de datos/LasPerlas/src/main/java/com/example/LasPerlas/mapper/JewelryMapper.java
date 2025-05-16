package com.example.LasPerlas.mapper;

import com.example.LasPerlas.dto.JewelryDTO;
import com.example.LasPerlas.model.Jewelry;

public class JewelryMapper {
    public static JewelryDTO toDTO(Jewelry jewelry) {
        JewelryDTO dto = new JewelryDTO();
        dto.setId(jewelry.getId());
        dto.setName(jewelry.getName());
        dto.setMaterial(jewelry.getMaterial());
        dto.setWeight(jewelry.getWeight());
        dto.setCharacteristic(jewelry.getCharacteristic());
        dto.setHasStone(jewelry.isHasStone());
        dto.setAvailableForSale(jewelry.isAvailableForSale());
        return dto;
    }

    public static Jewelry toEntity(JewelryDTO dto) {
        Jewelry jewelry = new Jewelry();
        jewelry.setId(dto.getId());
        jewelry.setName(dto.getName());
        jewelry.setMaterial(dto.getMaterial());
        jewelry.setWeight(dto.getWeight());
        jewelry.setCharacteristic(dto.getCharacteristic());
        jewelry.setHasStone(dto.isHasStone());
        jewelry.setAvailableForSale(dto.isAvailableForSale());
        return jewelry;
    }
}

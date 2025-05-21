package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.ClothingItemDto;

import java.util.List;

public interface IClothesService {

    ClothingItemDto save(ClothingItemDto clothingItemDto);
    List<ClothingItemDto> findAll();
    ClothingItemDto update(String id, ClothingItemDto clothingItemDto);
    ClothingItemDto findById(String id);

    List<ClothingItemDto> findByName(String name);

    void delete(String code);

    List<ClothingItemDto> findBySize(String size);
}

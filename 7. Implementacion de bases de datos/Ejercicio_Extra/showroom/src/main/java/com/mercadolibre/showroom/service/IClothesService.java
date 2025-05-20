package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.ClothingItemDto;

import java.util.List;

public interface IClothesService {

    ClothingItemDto save(ClothingItemDto clothingItemDto);
    List<ClothingItemDto> findAll();
    ClothingItemDto update(Long id, ClothingItemDto clothingItemDto);
    ClothingItemDto findById(Long id);

    List<ClothingItemDto> findByName(String name);

    void delete(Long code);

    List<ClothingItemDto> findBySize(String size);
}

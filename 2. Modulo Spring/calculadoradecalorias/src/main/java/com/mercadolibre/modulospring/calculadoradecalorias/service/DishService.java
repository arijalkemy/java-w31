package com.mercadolibre.modulospring.calculadoradecalorias.service;

import com.mercadolibre.modulospring.calculadoradecalorias.dto.DishDTO;
import com.mercadolibre.modulospring.calculadoradecalorias.dto.DishResponseDTO;

import java.util.List;

public interface DishService {
    public DishResponseDTO createDish(DishDTO dto);
    public List<DishResponseDTO> getAllDishes();
}

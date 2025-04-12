package com.mercadolibre.calorias.service;

import com.mercadolibre.calorias.dto.PlatoDTO;

import java.util.List;

public interface PlatoService {
    PlatoDTO calculateCalories(String nombrePlato, int peso);
    List<PlatoDTO> calculateCaloriesForMultipleDishes(List<PlatoDTO> platos);
}

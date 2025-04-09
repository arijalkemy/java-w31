package com.mercadolibre.contador.calorias.service;

import com.mercadolibre.contador.calorias.dto.IngredientDto;
import com.mercadolibre.contador.calorias.dto.PlateDto;

import java.util.List;

public interface IFoodService {

    List<IngredientDto> getListIngredient(PlateDto plate);
    Integer calculateCalories( PlateDto plate);

}

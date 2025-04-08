package com.mercadolibre.contadorcalorias.service;

import com.mercadolibre.contadorcalorias.dto.IngredientDTO;

public interface IIngredientService {
        IngredientDTO getIngredientWithHighestCalorie();
}

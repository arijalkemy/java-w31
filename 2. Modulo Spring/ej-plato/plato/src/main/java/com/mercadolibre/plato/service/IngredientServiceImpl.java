package com.mercadolibre.plato.service;

import com.mercadolibre.plato.dto.ResponseIngredientDto;
import com.mercadolibre.plato.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientServiceImpl implements IngredientService {
    @Autowired
    IngredientRepository ingredientRepository;
    @Override
    public ResponseIngredientDto getIngredientWithMostCalories() {
        return new ResponseIngredientDto(ingredientRepository.getIngredientWithMostCalories());
    }

}

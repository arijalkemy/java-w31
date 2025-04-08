package com.mercadolibre.contadorcalorias.service;

import com.mercadolibre.contadorcalorias.dto.IngredientDTO;
import com.mercadolibre.contadorcalorias.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
@Service
public class IngredientService implements IIngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public IngredientDTO getIngredientWithHighestCalorie() {
       return this.ingredientRepository.findAll().stream().max(Comparator.comparingInt(IngredientDTO::getCalories))
               .orElse(null);
    }
}

package com.bootcamp.calories_calculator.service;

import com.bootcamp.calories_calculator.dto.IngredientDto;
import com.bootcamp.calories_calculator.repository.IIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientServiceImpl implements IIngredientService {

    @Autowired
    IIngredientRepository ingredientRepository;

    @Override
    public List<IngredientDto> getIngredients() {
        return ingredientRepository.getIngredients().stream()
                .map(IngredientDto::buildFromIngredient)
                .collect(Collectors.toList());
    }

    @Override
    public IngredientDto getByName(String name) {
        return IngredientDto.buildFromIngredient(ingredientRepository.getByName(name));
    }
}

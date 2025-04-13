package com.mercadolibre.plato.service;

import com.mercadolibre.plato.dto.RequestDishDto;
import com.mercadolibre.plato.dto.ResponseIngredientDto;
import com.mercadolibre.plato.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    IngredientRepository ingredientRepository;

    @Override
    public Integer getCalories(RequestDishDto dish) {
        return dish.getIngredients().stream().mapToInt(i -> ingredientRepository.getCaloriesByNameAndWeight(i.getName(), i.getWeight())).sum();
    }

    @Override
    public List<ResponseIngredientDto> getCaloriesByIngredient(RequestDishDto dish) {
        return dish.getIngredients().stream().map(i -> new ResponseIngredientDto(ingredientRepository.getIngredientByNameAndWeight(i.getName(), i.getWeight()))).toList();
    }
}

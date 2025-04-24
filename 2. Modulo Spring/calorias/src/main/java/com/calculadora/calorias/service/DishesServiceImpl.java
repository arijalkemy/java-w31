package com.calculadora.calorias.service;

import com.calculadora.calorias.dto.DishDTO;
import com.calculadora.calorias.repository.IngredientRepository;
import com.calculadora.calorias.repository.IngredientRespositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DishesServiceImpl implements DishesService {
    @Autowired
    IngredientRepository ingredientRepository = new IngredientRespositoryImpl();
    @Override
    public int getCalories(DishDTO dish) {

       int n = dish.getIngredients().stream().mapToInt(i -> ingredientRepository.getCalories(i)).sum();
        return dish.getIngredients().stream().mapToInt(i -> ingredientRepository.getCalories(i)).sum();

    }

    @Override
    public Object getIngredients(DishDTO dish) {
        return null;
    }

}

package com.mercadolibre.bootcamp.calculadora.service;

import com.mercadolibre.bootcamp.calculadora.dto.IngredientDto;
import com.mercadolibre.bootcamp.calculadora.model.Ingredient;
import com.mercadolibre.bootcamp.calculadora.repository.IngredientRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientServiceImpl {

    private IngredientRepositoryImp ingredientRepositoryImp;

    @Autowired
    public IngredientServiceImpl(IngredientRepositoryImp ingredientRepositoryImp) {
        this.ingredientRepositoryImp = ingredientRepositoryImp;
    }

    public List<IngredientDto> getIngredients() {
        List<IngredientDto> ingredientDtos = new ArrayList<>();
        List<Ingredient> ingredients = ingredientRepositoryImp.getAllIngredients();
        for (Ingredient ingredient : ingredients) {
            ingredientDtos.add(new IngredientDto(ingredient.getName(), ingredient.getCalories()));
        }
        return ingredientDtos;
    }
}

package com.mercadolibre.contador.calorias.service;

import java.util.ArrayList;
import java.util.List;

import com.mercadolibre.contador.calorias.repository.IFoodRepository;
import org.springframework.stereotype.Service;

import com.mercadolibre.contador.calorias.dto.IngredientDto;
import com.mercadolibre.contador.calorias.dto.PlateDto;
import com.mercadolibre.contador.calorias.entity.Ingredient;
import com.mercadolibre.contador.calorias.repository.FoodRepository;

@Service
public class FoodService implements IFoodService {

    private final IFoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public Integer calculateCalories( PlateDto plate){

        Integer totalCalories = 0;
        for (IngredientDto ingredientDto: plate.getListIngredientDto()){
            Ingredient singleIngredient;
            singleIngredient = foodRepository.getTheIngredient(ingredientDto.getName());
            if (singleIngredient == null){
                throw new IllegalArgumentException();
            }
            totalCalories += singleIngredient.getCalories();
        }
        return totalCalories;
    }

    @Override
    public List<IngredientDto> getListIngredient(PlateDto plate){
        
        List<IngredientDto> listIngredientDto = new ArrayList<>(); 

        for (IngredientDto ingredientDtoIter: plate.getListIngredientDto()){
            Ingredient singleIngredient;
            singleIngredient = foodRepository.getTheIngredient(ingredientDtoIter.getName());
            if (singleIngredient == null){
                throw new IllegalArgumentException();
            }
            IngredientDto ingredientDto = new IngredientDto(
                singleIngredient.getName(),
                singleIngredient.getCalories()
            );
            listIngredientDto.add(ingredientDto);
        }

        return listIngredientDto;
    }
}

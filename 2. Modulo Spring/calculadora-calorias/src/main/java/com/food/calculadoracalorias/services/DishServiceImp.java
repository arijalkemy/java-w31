package com.food.calculadoracalorias.services;

import com.food.calculadoracalorias.dto.DishDTO;
import com.food.calculadoracalorias.dto.DishResponseDTO;
import com.food.calculadoracalorias.dto.IngredientDTO;
import com.food.calculadoracalorias.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishServiceImp implements DishService{
    private final IngredientRepository ingredientRepository;

    public DishServiceImp(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }


    @Override
    public DishResponseDTO calculateCalories(DishDTO dish) {
        DishResponseDTO response = new DishResponseDTO(dish);
        Integer total = 0;
        Integer maxCalories = 0;

        for(IngredientDTO ingre : response.getIngredients()){
            calculateIngredientCalories(ingre);
            total += ingre.getCalories();
            if(ingre.getCalories() > maxCalories){
               response.setCaloric(ingre);
               maxCalories = ingre.getCalories();
            }
        }
        response.setCalories(total);
        return response;
    }

    private void calculateIngredientCalories(IngredientDTO ingredient) {
        ingredient.setCalories(0);
        IngredientDTO ingredientFromRepository = ingredientRepository.findIngredientByName(ingredient.getName());
        if(ingredientFromRepository != null){
            ingredient.setCalories((int) (ingredient.getWeight() * ingredientFromRepository.getCalories() / 100.f));
        }
    }

    @Override
    public List<DishResponseDTO> calculateAllCalories(List<DishDTO> dishes) {
        List<DishResponseDTO> result = new ArrayList<>();
        for(DishDTO dish : dishes){
            result.add(this.calculateCalories(dish));
        }
        return result;
    }
}

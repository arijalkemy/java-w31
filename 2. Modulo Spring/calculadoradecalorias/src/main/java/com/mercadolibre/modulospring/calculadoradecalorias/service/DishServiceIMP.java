package com.mercadolibre.modulospring.calculadoradecalorias.service;

import com.mercadolibre.modulospring.calculadoradecalorias.dto.DishDTO;
import com.mercadolibre.modulospring.calculadoradecalorias.dto.DishResponseDTO;
import com.mercadolibre.modulospring.calculadoradecalorias.dto.IngredientDTO;
import com.mercadolibre.modulospring.calculadoradecalorias.repository.DishRepository;
import com.mercadolibre.modulospring.calculadoradecalorias.repository.IngredientRepositoryIMP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishServiceIMP implements DishService {
    @Autowired
    IngredientRepositoryIMP repository=new IngredientRepositoryIMP();
    DishRepository dishRepository=new DishRepository();
    @Override
    public DishResponseDTO createDish(DishDTO dto){

        List<IngredientDTO> ingredients = new ArrayList<>();
        dto.getIngredientsName().forEach(ingredient -> ingredients.add(repository.loadIngredients(ingredient)));
        int calories=0;
        IngredientDTO mostcalories=ingredients.get(0);
        for(IngredientDTO ingredient: ingredients){
            if(ingredient.getCalories()>mostcalories.getCalories()){
                mostcalories=ingredient;
            }
            calories+=ingredient.getCalories();
        }
        DishResponseDTO dishResponseDTO = new DishResponseDTO(dto.getName(), dto.getWeight(),ingredients,calories,mostcalories);
        dishRepository.add(dishResponseDTO);


        return dishResponseDTO;
    }
    @Override
    public List<DishResponseDTO> getAllDishes() {
        return dishRepository.getData();
    }

}

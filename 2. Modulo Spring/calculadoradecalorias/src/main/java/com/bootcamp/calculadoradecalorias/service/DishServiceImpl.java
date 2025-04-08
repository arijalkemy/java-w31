package com.bootcamp.calculadoradecalorias.service;

import com.bootcamp.calculadoradecalorias.dto.DishDto;
import com.bootcamp.calculadoradecalorias.dto.DishRequestDto;
import com.bootcamp.calculadoradecalorias.dto.DishesRequestDto;
import com.bootcamp.calculadoradecalorias.entity.Ingredient;
import com.bootcamp.calculadoradecalorias.repository.IngredientRepository;
import com.bootcamp.calculadoradecalorias.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class DishServiceImpl implements DishService{
    @Autowired
    IngredientRepository ingredientRepository;
    @Override
    public DishDto dishInformation(DishRequestDto dishReq) {
        List<Ingredient> ing = new ArrayList<>();
        dishReq.getIngredient().forEach(ingrediente -> {
            ing.add(ingredientRepository.findIngredient(ingrediente.getName()));
        });
        
        DishDto dishInfo = Mapper.toDishDto(ing);
        return dishInfo;
    }

    @Override
    public List<DishDto> dishesInformation(DishesRequestDto dishes) {
        List<DishDto> dishesList = new ArrayList<>();
        dishes.getDishes().forEach(dish -> {
            dishesList.add(dishInformation(dish));
        });
        return dishesList;
    }
}

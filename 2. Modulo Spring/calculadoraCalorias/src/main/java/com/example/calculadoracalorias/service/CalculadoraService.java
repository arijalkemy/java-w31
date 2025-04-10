package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.dto.DishInfoDTo;
import com.example.calculadoracalorias.dto.IngredientDto;
import com.example.calculadoracalorias.model.Dish;
import com.example.calculadoracalorias.model.Ingredient;
import com.example.calculadoracalorias.repository.IDishRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculadoraService implements ICalculadoraService{
    @Autowired
    IDishRepository dishRepository;

    @Override
    public String totalCalories(String name, Integer weight) {
        Integer totalCalories = 0;
        List<Dish> dishes = dishRepository.findAllDishes();
        for (Dish dish : dishes){
            if(dish.getName().equals(name)){
                for(Ingredient ingredient : dish.getIngredients()){
                    totalCalories += ingredient.getCalories();
                }
            }
        }

        return "El total de calorias del plato: " + name + " es: " + totalCalories;
    }

    @Override
    public List<IngredientDto> searchCaloriesAndIngredients(String name, Integer weight) {
        List<Dish> dishes = dishRepository.findAllDishes();
        List<IngredientDto> ingredientDtoList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for (Dish dish : dishes){
            if(dish.getName().equals(name)){
                for(Ingredient ingredient : dish.getIngredients()){
                    ingredientDtoList.add(mapper.convertValue(ingredient, IngredientDto.class));
                }
            }
        }

        return ingredientDtoList;
    }

    @Override
    public IngredientDto searchHigherIngredient(String name, Integer weight) {
        Integer higerCalories = 0;
        IngredientDto ingredientDto = null;
        ObjectMapper mapper = new ObjectMapper();
        List<Dish> dishes = dishRepository.findAllDishes();
        for (Dish dish : dishes){
            if(dish.getName().equals(name)){
                for(Ingredient ingredient : dish.getIngredients()){
                    if(higerCalories < ingredient.getCalories()){
                        higerCalories = ingredient.getCalories();
                        ingredientDto = mapper.convertValue(ingredient, IngredientDto.class);
                    }
                }
            }
        }
        return ingredientDto;
    }

    @Override
    public List<DishInfoDTo> calculateDishes(List<Dish> dishes) {
        List<DishInfoDTo> dishInfoDToList = new ArrayList<>();

        for(Dish dish : dishes){
            String totalCalories = totalCalories(dish.getName(), dish.getWeight());
            List<IngredientDto> ingredientDtoList = searchCaloriesAndIngredients(dish.getName(), dish.getWeight());
            IngredientDto higherCalories = searchHigherIngredient(dish.getName(), dish.getWeight());

            dishInfoDToList.add(new DishInfoDTo(totalCalories, ingredientDtoList, higherCalories));
        }

        return dishInfoDToList;
    }
}

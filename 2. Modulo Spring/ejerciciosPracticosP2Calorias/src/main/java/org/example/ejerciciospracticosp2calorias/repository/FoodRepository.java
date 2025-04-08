package org.example.ejerciciospracticosp2calorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ejerciciospracticosp2calorias.dto.FoodDto;
import org.example.ejerciciospracticosp2calorias.entity.Ingredient;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FoodRepository implements FoodRepositoryInterface{

    public List<Ingredient> loadIngredientData(){
        List<Ingredient> ingredientList;
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            ingredientList = objectMapper.readValue(new File("src/main/resources/data/food.json"), new TypeReference<>() {});
        } catch (Exception e) {
            System.out.println("No fue posible mapear food.json");
            throw new RuntimeException(e);
        }
        return ingredientList;
    }

    public List<FoodDto> loadFoodData(List<Ingredient> ingredientListTotal){
        List<Ingredient> ingredientListPerFood = new ArrayList<>();
        ingredientListPerFood.add(ingredientListTotal.get(0));
        ingredientListPerFood.add(ingredientListTotal.get(2));
        ingredientListPerFood.add(ingredientListTotal.get(3));
        ingredientListPerFood.add(ingredientListTotal.get(4));

        FoodDto food1= new FoodDto("Hot Dog",ingredientListPerFood);
        FoodDto food2= new FoodDto("Burger",ingredientListPerFood);
        FoodDto food3= new FoodDto("Spaguetti",ingredientListPerFood);

        return List.of(food1,food2,food3);
    }
}

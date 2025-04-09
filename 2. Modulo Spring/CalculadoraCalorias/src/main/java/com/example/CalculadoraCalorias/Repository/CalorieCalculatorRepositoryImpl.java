package com.example.CalculadoraCalorias.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.example.CalculadoraCalorias.DTO.DishDTO;
import com.example.CalculadoraCalorias.DTO.IngredientDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class CalorieCalculatorRepositoryImpl implements CalorieCalculatorRepository {
    List<IngredientDTO> ingredients;
    List<DishDTO> dishes;

    public CalorieCalculatorRepositoryImpl() {
        this.ingredients = loadDataBase();
        this.dishes = new ArrayList<>();
    }

    private List<IngredientDTO> loadDataBase() {
    File file = null;
    try {
      file = ResourceUtils.getFile("classpath:food.json");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    ObjectMapper objectMapper = new ObjectMapper();
    TypeReference<List<IngredientDTO>> typeRef = new TypeReference<>() {};
    List<IngredientDTO> priceDTOS = null;
    try {
      priceDTOS = objectMapper.readValue(file, typeRef);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return priceDTOS;
  }

    @Override
    public DishDTO getDishByName(String name) {
      return dishes.stream()
                   .filter(d -> d.getName().equalsIgnoreCase(name))
                   .findFirst()
                   .orElse(null);
    }

    @Override
    public ResponseEntity<?> createDish(DishDTO dish) {
      DishDTO dishDTO = dishes.stream()
                .filter(d -> d.getName().equalsIgnoreCase(dish.getName()))
                .findFirst()
                .orElse(null);       
      if (dishDTO == null) {
        dishes.add(dish);
        return new ResponseEntity<>("Plato creado con éxito", HttpStatus.OK);
      }  else {
        return new ResponseEntity<>("El plato no puede crearse, ya hay otro plato con ese nombre", HttpStatus.CONFLICT);
      }
      }

}

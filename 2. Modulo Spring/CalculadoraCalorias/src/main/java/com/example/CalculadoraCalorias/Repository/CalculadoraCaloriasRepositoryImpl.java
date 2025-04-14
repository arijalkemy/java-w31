package com.example.CalculadoraCalorias.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.example.CalculadoraCalorias.DTO.DishDTO;
import com.example.CalculadoraCalorias.DTO.IngredientDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class CalculadoraCaloriasRepositoryImpl implements CalculadoraCaloriasRepository {
  private List<IngredientDTO> ingredients;
  private List<DishDTO> dishes;
  private Set<String> allowedIngredientNames;

  public CalculadoraCaloriasRepositoryImpl() {
    this.ingredients = loadDataBase();
    this.dishes = new ArrayList<>();
    this.allowedIngredientNames = new HashSet<>();
    for (IngredientDTO ingredient : this.ingredients) {
      allowedIngredientNames.add(ingredient.getName());
    }
  }

  private List<IngredientDTO> loadDataBase() {
    File file = null;
    try {
      file = ResourceUtils.getFile("classpath:food.json");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return new ArrayList<>();
    }
    ObjectMapper objectMapper = new ObjectMapper();
    TypeReference<List<IngredientDTO>> typeRef = new TypeReference<>() {
    };
    List<IngredientDTO> priceDTOS = null;
    try {
      priceDTOS = objectMapper.readValue(file, typeRef);
    } catch (IOException e) {
      e.printStackTrace();
      return new ArrayList<>();
    }
    return priceDTOS;
  }

  @Override
  public Boolean doesDishExists(DishDTO dish) {
    List<DishDTO> equalDishes = dishes.stream()
        .filter(d -> d.getName().equals(dish.getName()))
        .toList();
    return !equalDishes.isEmpty();
  }

  @Override
  public Boolean addNewDish(DishDTO dish) {
    if (doesDishExists(dish)) {
      return false;
    }
    dishes.add(dish);
    return true;
  }

  @Override
  public DishDTO getDishByName(String name) {
    return dishes.stream()
        .filter(d -> d.getName().equals(name))
        .findFirst()
        .orElse(null);
  }

  @Override
  public boolean areIngredientsValid(List<IngredientDTO> dishIngredients) {
    for (IngredientDTO ingredient : dishIngredients) {
      if (!this.allowedIngredientNames.contains(ingredient.getName())) {
        return false;
      }
    }
    return true;
  }

  @Override
  public List<DishDTO> getAllDishes() {
    return dishes;
  }
}

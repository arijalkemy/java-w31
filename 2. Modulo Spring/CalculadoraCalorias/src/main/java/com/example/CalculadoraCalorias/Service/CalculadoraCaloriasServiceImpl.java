package com.example.CalculadoraCalorias.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CalculadoraCalorias.DTO.DishDTO;
import com.example.CalculadoraCalorias.DTO.IngredientDTO;
import com.example.CalculadoraCalorias.Exceptions.EntityAlreadyExistsException;
import com.example.CalculadoraCalorias.Exceptions.InvalidEntityException;
import com.example.CalculadoraCalorias.Exceptions.NotFoundException;
import com.example.CalculadoraCalorias.Repository.CalculadoraCaloriasRepository;

@Service
public class CalculadoraCaloriasServiceImpl implements CalculadoraCaloriasService {
    @Autowired
    CalculadoraCaloriasRepository calculadoraCaloriasRepository;

    public String newDish(DishDTO dish) {
        if (dish.getIngredients().size() <= 0) {
            throw new InvalidEntityException("No se puede crear un plato sin ingredientes.");
        }
        if (!calculadoraCaloriasRepository.areIngredientsValid(dish.getIngredients())) {
            throw new NotFoundException("No disponemos de los ingredientes para preparar el plato.");
        }
        Boolean result = calculadoraCaloriasRepository.addNewDish(dish);
        if (!result) {
            throw new EntityAlreadyExistsException(
                    "EL plato de nombre " + dish.getName() + " ya se encuentra registrado.");
        }
        return "El plato se registró exitosamente.";
    }

    public Integer getTotalCalories(String dishName) {
        DishDTO dish = calculadoraCaloriasRepository.getDishByName(dishName);
        if (dish == null) {
            throw new NotFoundException("No se encontró un plato de nombre " + dishName);
        }
        Integer totalCalories = 0;
        Integer ingredientWeight = dish.getWeight() / dish.getIngredients().size();

        for (IngredientDTO ingredient : dish.getIngredients()) {
            totalCalories += ingredient.getCalories() * ingredientWeight / 100;
        }

        return totalCalories;
    }

    public List<IngredientDTO> getIngredients(String dishName) {
        DishDTO dish = calculadoraCaloriasRepository.getDishByName(dishName);
        if (dish == null) {
            throw new NotFoundException("No se encontró un plato de nombre " + dishName);
        }
        return dish.getIngredients();
    }

    public IngredientDTO getMostCaloricIngredient(String dishName) {
        DishDTO dish = calculadoraCaloriasRepository.getDishByName(dishName);
        if (dish == null) {
            throw new NotFoundException("No se encontró un plato de nombre " + dishName);
        }
        List<IngredientDTO> ingredients = dish.getIngredients();
        if (ingredients.isEmpty()) {
            throw new NotFoundException("No se encontraron ingredientes para el plato " + dishName);
        }

        int maxCalories = 0;
        IngredientDTO mostCaloric = null;
        for (IngredientDTO ingredient : ingredients) {
            if (mostCaloric == null || ingredient.getCalories() > maxCalories) {
                maxCalories = ingredient.getCalories();
                mostCaloric = ingredient;
            }
        }
        return mostCaloric;
    }

    @Override
    public List<DishDTO> getAllDishes() {
        return calculadoraCaloriasRepository.getAllDishes();
    }
}

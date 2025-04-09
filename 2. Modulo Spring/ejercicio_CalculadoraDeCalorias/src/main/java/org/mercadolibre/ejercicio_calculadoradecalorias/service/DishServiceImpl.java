package org.mercadolibre.ejercicio_calculadoradecalorias.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mercadolibre.ejercicio_calculadoradecalorias.dto.DishDTO;
import org.mercadolibre.ejercicio_calculadoradecalorias.dto.IngredientsDTO;
import org.mercadolibre.ejercicio_calculadoradecalorias.entity.Dish;
import org.mercadolibre.ejercicio_calculadoradecalorias.entity.Ingredients;
import org.mercadolibre.ejercicio_calculadoradecalorias.exceptions.BadRequestException;
import org.mercadolibre.ejercicio_calculadoradecalorias.exceptions.NotFoundException;
import org.mercadolibre.ejercicio_calculadoradecalorias.repository.DishRepository;
import org.mercadolibre.ejercicio_calculadoradecalorias.repository.IngredientsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishServiceImpl implements DishService {

    DishRepository dishRepository;
    IngredientsRepository ingredientsRepository;

    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Override
    public List<DishDTO> findAllDishes() {
        ObjectMapper mapper = new ObjectMapper();
        List<Dish> dishes = dishRepository.findAll();

        if(dishes.isEmpty()) {
            throw new NotFoundException("No se encontraron platos.");
        }

        return dishes.stream().map(d -> mapper.convertValue(d, DishDTO.class)).collect(Collectors.toList());
    }

    @Override
    public String addDish(DishDTO dishDTO) {
        if(dishDTO == null) {
            throw new BadRequestException("El dish no puede ser nulo");
        }

        if(dishDTO.getName() == null || dishDTO.getName().isEmpty()) {
            throw new BadRequestException("El plato debe tener nombre");
        }

        if(dishDTO.getWeight() <= 0) {
            throw new BadRequestException("El peso del plato debe ser mayor que 0");
        }

        if(dishDTO.getIngredients() == null || dishDTO.getIngredients().isEmpty()) {
            throw new BadRequestException("El plato debe tener una lista de ingredientes");
        }

        List<Ingredients> ingredientsList = dishDTO.getIngredients()
                .stream()
                .map(ingredientDTO -> new Ingredients(ingredientDTO.getName(), ingredientDTO.getCalories()))
                .collect(Collectors.toList());

        Dish dish = new Dish(dishDTO.getName(), dishDTO.getWeight(), ingredientsList);

        dishRepository.saveDish(dish);

        return "Se ha agregado el el plato con exito";
    }

    @Override
    public String totalCaloriesDish(String name) {
        Dish dishFound = returnDish(name);

        int contCalories = 0;

        for(Ingredients ing : dishFound.getIngredients()){
            contCalories += ing.getCalories();
        }

        return "Plato: " + dishFound.getName() + ", Calories: " + contCalories;
    }

    @Override
    public List<IngredientsDTO> listOfIngredientsDish(String name) {
        Dish dish = returnDish(name);
        ObjectMapper mapper = new ObjectMapper();
        List<Ingredients> ingredientsList = dish.getIngredients();

        return ingredientsList.stream().map(i -> mapper.convertValue(i, IngredientsDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Ingredients getGreaterIngredientCalories(String name) {
        Dish dish = returnDish(name);
        Ingredients ingredient = dish.getIngredients().get(0);

        for(Ingredients ing : dish.getIngredients()) {
            if(ing.getCalories() > ingredient.getCalories()) ingredient = ing;
        }

        return ingredient;
    }

    private Dish returnDish(String name) {
        List<Dish> dishList = dishRepository.findAll();
        if(dishList.isEmpty()) {
            throw new NotFoundException("No se encontraron platos.");
        }

        return dishList.stream()
                .filter(d -> d.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("No se encontró el plato."));
    }


}

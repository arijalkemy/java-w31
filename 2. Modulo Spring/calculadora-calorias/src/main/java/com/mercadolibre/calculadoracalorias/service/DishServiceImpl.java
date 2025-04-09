package com.mercadolibre.calculadoracalorias.service;

import com.mercadolibre.calculadoracalorias.dto.DishRequestDTO;
import com.mercadolibre.calculadoracalorias.dto.IngredientRequestDTO;
import com.mercadolibre.calculadoracalorias.exception.NotFoundException;
import com.mercadolibre.calculadoracalorias.dto.DishDTO;
import com.mercadolibre.calculadoracalorias.dto.IngredientDTO;
import com.mercadolibre.calculadoracalorias.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService {
    private IngredientRepository ingredientRepository;

    public DishServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public void validIngredients(DishRequestDTO dishRequest) {
        for (IngredientRequestDTO ingredientRequest : dishRequest.getIngredients()) {
            if (ingredientRepository.findIngredientByname(ingredientRequest.getName()).isEmpty()) {
                throw new NotFoundException("Alguno de los ingredientes no existe");
            }
        }
    }

    @Override
    public Integer calculateDishCalories(DishDTO dishDTO) {

        return dishDTO.getIngredients().stream()
                .mapToInt(IngredientDTO::getCalories).sum();
    }

    @Override
    public String listIngredientsAndCalories(DishDTO dishDTO) {
        return dishDTO.getIngredients().stream()
                .map(IngredientDTO::toString).toString();
    }

    @Override
    public IngredientDTO getMostCaloricIngredient(DishDTO dishDTO) {

        Optional<IngredientDTO> mostCaloricIngredient = dishDTO.getIngredients().stream()
                .max(Comparator.comparingInt(IngredientDTO::getCalories));

        if (mostCaloricIngredient.isPresent()) {
            return mostCaloricIngredient.get();
        }
        else {
            throw new NotFoundException("No se encontró el ingrediente más calórico");
        }
    }

    @Override
    public DishDTO calculate(DishRequestDTO dish) {

        try {
            validIngredients(dish);
        }
        catch {
            throw new NotFoundException();
        }

        DishDTO response = new DishDTO(dish.getName(), dish.getIngredients());



        return response;
    }
}

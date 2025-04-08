package com.calculadoradecalorias.calculadoradecalorias.service;

import com.calculadoradecalorias.calculadoradecalorias.dto.DishDataResponseTDO;
import com.calculadoradecalorias.calculadoradecalorias.dto.DishRequestDTO;
import com.calculadoradecalorias.calculadoradecalorias.dto.IngredientResponseDTO;
import com.calculadoradecalorias.calculadoradecalorias.model.Ingredient;
import com.calculadoradecalorias.calculadoradecalorias.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DishServiceImpl implements DishService{

    @Autowired
    IngredientRepository ingredientRepository;

    @Override
    public DishDataResponseTDO calculateDish(DishRequestDTO d) {

        List<Ingredient> ingredientesRepo = ingredientRepository.findAllIngredient();

        Integer totalCalorie = d.getIngredienteList().stream()
                .mapToInt(ingrediente -> {
                    Ingredient ingredienteRepo = ingredientesRepo.stream()
                            .filter(i -> i.getName().equalsIgnoreCase(ingrediente.getName()))
                            .findFirst()
                            .orElseThrow(() -> new RuntimeException("Error: No encontrado " + ingrediente.getName()));

                    return ingredienteRepo.getCalories() * ingrediente.getWeight() / 100;
                }).sum();

        //Vamos a ver el tema de la lista de ingredientes
        List<IngredientResponseDTO> listaIngredientesDTO = d.getIngredienteList().stream()
                .map(ingrediente -> {
                    Ingredient ingredienteRepository = ingredientesRepo.stream()
                            .filter(a -> a.getName().equalsIgnoreCase(ingrediente.getName()))
                            .findFirst()
                            .orElseThrow(() -> new RuntimeException("Error: No encontrado " + ingrediente.getName()));

                    int calorias = ingredienteRepository.getCalories() * ingrediente.getWeight() / 100;

                    return new IngredientResponseDTO(ingrediente.getName(), calorias);
                })
                .collect(Collectors.toList());

        String mayorCaloria = listaIngredientesDTO.stream()
                .max(Comparator.comparingInt(IngredientResponseDTO::getCalories))
                .map(IngredientResponseDTO::getName)
                .orElse("N/A");

        DishDataResponseTDO dishDataResponseTDO = new DishDataResponseTDO(d.getName(),totalCalorie,listaIngredientesDTO,mayorCaloria);

        return dishDataResponseTDO;
    }

    @Override
    public List<DishDataResponseTDO> calculateMultipleDishes(List<DishRequestDTO> dishes) {

        return dishes.stream()
                .map(x -> calculateDish(x))
                .collect(Collectors.toList());
    }

}

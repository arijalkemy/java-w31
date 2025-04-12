package com.mercadolibre.calorias.service;

import com.mercadolibre.calorias.dto.IngredienteDTO;
import com.mercadolibre.calorias.dto.PlatoDTO;
import com.mercadolibre.calorias.model.Ingrediente;
import com.mercadolibre.calorias.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatoServiceImpl implements PlatoService {

    @Autowired
    private IngredienteRepository ingredienteRepository;

    public PlatoDTO calculateCalories(String nombrePlato, int peso) {
        List<Ingrediente> ingredientes = ingredienteRepository.findAll();

        // Supposes there are ingredients for the given plato name
        List<IngredienteDTO> ingredientesDTO = ingredientes.stream()
                .map(ing -> new IngredienteDTO(ing.getName(), ing.getCalories()))
                .collect(Collectors.toList());

        int totalCalories = ingredientesDTO.stream()
                .mapToInt(IngredienteDTO::getCalories)
                .sum();

        IngredienteDTO maxCaloriasIngrediente = ingredientesDTO.stream()
                .max((i1, i2) -> Integer.compare(i1.getCalories(), i2.getCalories()))
                .orElse(null);

        return new PlatoDTO(nombrePlato, peso, totalCalories, ingredientesDTO, maxCaloriasIngrediente);
    }

    public List<PlatoDTO> calculateCaloriesForMultipleDishes(List<PlatoDTO> platos) {
        return platos.stream()
                .map(plato -> calculateCalories(plato.getNombrePlato(), plato.getPeso()))
                .collect(Collectors.toList());
    }
}

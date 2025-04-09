package org.mercadolibre.ejercicio_calculadoradecalorias.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mercadolibre.ejercicio_calculadoradecalorias.dto.IngredientsDTO;
import org.mercadolibre.ejercicio_calculadoradecalorias.entity.Ingredients;
import org.mercadolibre.ejercicio_calculadoradecalorias.exceptions.NotFoundException;
import org.mercadolibre.ejercicio_calculadoradecalorias.repository.IngredientsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientsServiceImpl implements IngredientsService{
    IngredientsRepository ingredientsRepository;

    public IngredientsServiceImpl(IngredientsRepository ingredientsRepository) {
        this.ingredientsRepository = ingredientsRepository;
    }

    @Override
    public List<IngredientsDTO> getAllIngredients() {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Ingredients> ingredientsList = ingredientsRepository.findAll();

        if(ingredientsList.isEmpty()){
            throw new NotFoundException("Ingredientes no encontrado");
        }

        return ingredientsList.stream().map(i -> objectMapper.convertValue(i, IngredientsDTO.class))
                .collect(Collectors.toList());
    }


}

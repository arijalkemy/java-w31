package org.example.calculadoradecalorias.service;

import org.example.calculadoradecalorias.dto.IngredientsDto;

import java.io.IOException;
import java.util.List;

public interface IRestaurantService {
    List<IngredientsDto> getIngredientsByDish(String dishName) throws IOException;
}

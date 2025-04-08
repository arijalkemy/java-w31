package com.mercadolibre.contadorcalorias.model;

import com.mercadolibre.contadorcalorias.dto.IngredientDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    private List<IngredientDTO> ingredients = new ArrayList<>();
}

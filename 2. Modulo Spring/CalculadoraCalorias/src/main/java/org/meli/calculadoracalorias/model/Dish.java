package org.meli.calculadoracalorias.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    private String name;
    private int weight;
    private List<Ingredient> ingredients;
    int calories;
}

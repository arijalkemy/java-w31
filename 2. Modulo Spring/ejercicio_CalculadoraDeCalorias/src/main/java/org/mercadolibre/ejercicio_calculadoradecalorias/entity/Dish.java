package org.mercadolibre.ejercicio_calculadoradecalorias.entity;

import lombok.*;
import org.mercadolibre.ejercicio_calculadoradecalorias.dto.IngredientsDTO;

import java.util.List;

@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dish {
    private String name;
    private int weight;
    private List<Ingredients> ingredients;
}

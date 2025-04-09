package org.mercadolibre.ejercicio_calculadoradecalorias.dto;

import lombok.*;
import org.mercadolibre.ejercicio_calculadoradecalorias.entity.Ingredients;

import java.util.List;

@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientsDTO {
    private String name;
    private int calories;
}

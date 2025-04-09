package org.mercadolibre.ejercicio_calculadoradecalorias.dto;


import lombok.*;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class DishDTO {
    private String name;
    private int weight;
    private List<IngredientsDTO> ingredients;
}

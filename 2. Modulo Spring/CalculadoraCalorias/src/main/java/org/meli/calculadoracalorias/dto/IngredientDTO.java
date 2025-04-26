package org.meli.calculadoracalorias.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngredientDTO {
    private String name;
    private int calories;
}
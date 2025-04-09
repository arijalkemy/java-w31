package org.mercadolibre.ejercicio_calculadoradecalorias.entity;

import lombok.*;

@Data
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ingredients {
    private String name;
    private int calories;
}

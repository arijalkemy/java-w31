package com.mercadolibre.maolaya.ejercicio_deporte.Model.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class SportDto implements Serializable {
    private String name;
    private String level;
}

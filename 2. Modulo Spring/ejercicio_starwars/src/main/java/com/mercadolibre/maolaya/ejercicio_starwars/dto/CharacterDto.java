package com.mercadolibre.maolaya.ejercicio_starwars.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CharacterDto implements Serializable {
    private String name;
    private Integer heigth;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;
}

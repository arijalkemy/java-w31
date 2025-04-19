package com.mercadolibreexample.starwarnames.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PersonajeDto {
    private String name;
    private int height;
    private String mass;
    private String gender;
    private String homeworld;
    private String species;
}

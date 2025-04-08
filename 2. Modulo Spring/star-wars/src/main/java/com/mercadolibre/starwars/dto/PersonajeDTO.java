package com.mercadolibre.starwars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PersonajeDTO implements Serializable {
    private String name;
    private String height;
    private String mass;
    private String gender;
    private String homeworld;
    private String species;
}

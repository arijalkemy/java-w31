package com.personajesstarwars.personajesstarwars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class PersonajeDTO implements Serializable {
    private String name, gender, homeworld, species;
    private String height;
    private String mass;
}

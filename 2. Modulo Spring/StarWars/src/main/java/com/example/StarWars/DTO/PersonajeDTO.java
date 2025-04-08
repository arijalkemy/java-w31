package com.example.StarWars.DTO;

import java.io.Serializable;

import com.example.StarWars.Entities.Personaje;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonajeDTO implements Serializable {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;

    public PersonajeDTO (String name, Integer height, Integer mass, String gender, String homeworld, String species) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }

    public static PersonajeDTO convertToDTO(Personaje personaje) {
        return new PersonajeDTO(
            personaje.getName(),
            personaje.getHeight(),
            personaje.getMass(),
            personaje.getGender(),
            personaje.getHomeworld(),
            personaje.getSpecies()
        );
    }
}

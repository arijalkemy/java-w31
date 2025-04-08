package com.bootcamp.ejercicio_starwars.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonajeDto implements Serializable {
    private String name;
    private Integer height;
    private Integer mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthDate;
    private String gender;
    private String homeworld;
    private String species;

    public PersonajeDto(String name, Integer height, Integer maass, String hairColor, String skinColor, String eyeColor, String birthDate, String gender, String homeworld, String species) {
        this.name = name;
        this.height = height;
        this.mass = maass;
        this.hairColor = hairColor;
        this.skinColor = skinColor;
        this.eyeColor = eyeColor;
        this.birthDate = birthDate;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }

    public PersonajeDto(String name, Integer height, Integer maass, String gender, String homeworld, String species) {
        this.name = name;
        this.height = height;
        this.mass = maass;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }

}

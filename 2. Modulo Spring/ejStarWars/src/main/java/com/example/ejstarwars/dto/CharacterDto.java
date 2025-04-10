package com.example.ejstarwars.dto;

import lombok.Data;
import lombok.Setter;


@Setter
@Data
public class CharacterDto {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;

    public CharacterDto(String name, Integer height, Integer mass, String gender, String homeworld, String species) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }
}

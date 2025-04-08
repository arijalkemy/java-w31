package com.starwars.starwars.dto;

import java.io.Serializable;

public class CharacterDTO implements Serializable {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;

    public CharacterDTO(String gender, Integer height, String homeworld, Integer mass, String name, String species) {
        this.gender = gender;
        this.height = height;
        this.homeworld = homeworld;
        this.mass = mass;
        this.name = name;
        this.species = species;
    }

    public String getGender() {
        return gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getMass() {
        return mass;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }
}

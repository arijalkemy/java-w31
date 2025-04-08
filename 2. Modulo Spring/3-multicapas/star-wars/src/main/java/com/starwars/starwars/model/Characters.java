package com.starwars.starwars.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Characters {
    private String name;
    private Integer height;
    private Integer mass;
    @JsonProperty("hair_color")
    private String hairColor;
    @JsonProperty("skin_color")
    private String skinColor;
    @JsonProperty("eye_color")
    private String eyeColor;
    @JsonProperty("birth_year")
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;

    public Characters(String species, String birthYear, String eyeColor, String gender, String hairColor, Integer height, String homeworld, Integer mass, String name, String skinColor) {
        this.species = species;
        this.birthYear = birthYear;
        this.eyeColor = eyeColor;
        this.gender = gender;
        this.hairColor = hairColor;
        this.height = height;
        this.homeworld = homeworld;
        this.mass = mass;
        this.name = name;
        this.skinColor = skinColor;
    }

    public Characters() {
    }

    public String getName() {
        return name;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public String getGender() {
        return gender;
    }

    public Integer getHeight() {
        return height;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public Integer getMass() {
        return mass;
    }

    public String getSpecies() {
        return species;
    }
}

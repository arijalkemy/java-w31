package com.fernandotorres.multicapa.dto;

import java.util.Objects;


public class PersonajeDTO {
    private String name;
    private   int   height;
    private int mass;
    private    String       gender;
    private   String homeworld;
    private    String        species;

    public PersonajeDTO(String name, int height, int mass, String gender, String homeworld, String species) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonajeDTO that = (PersonajeDTO) o;
        return height == that.height && mass == that.mass && Objects.equals(name, that.name) && Objects.equals(gender, that.gender) && Objects.equals(homeworld, that.homeworld) && Objects.equals(species, that.species);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, height, mass, gender, homeworld, species);
    }

}




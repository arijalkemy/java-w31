package com.example.ejstarwars.entity;

import lombok.Getter;
import javax.persistence.Entity;

@Getter
@Entity
public class Character {
    private String name;
    private Integer height;
    private Integer mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;
}

package com.miprimerproyecto.pruebaspring.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Character {
    private String name;
    private String height;
    private String mass;
    
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
}

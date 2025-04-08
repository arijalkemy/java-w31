package com.personajesstarwars.personajesstarwars.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Personaje {
    private String eyeColor;
    private String name, hair_color, skin_color, eye_color, birth_year, gender, homeworld, species;
    private String height;
    private String mass;

}

package com.spring.personajesdestarwars.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.spring.personajesdestarwars.util.CustomIntegerDeserializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Personaje {
    @JsonProperty("name")
    private String name;

    @JsonDeserialize(using = CustomIntegerDeserializer.class)
    @JsonProperty("height")
    private Integer height;

    @JsonDeserialize(using = CustomIntegerDeserializer.class)
    @JsonProperty("mass")
    private Integer mass;

    @JsonProperty("hair_color")
    private String hairColor;

    @JsonProperty("skin_color")
    private String skinColor;

    @JsonProperty("eye_color")
    private String eyeColor;

    @JsonProperty("birth_year")
    private String birthYear;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("homeworld")
    private String homeworld;

    @JsonProperty("species")
    private String species;
}
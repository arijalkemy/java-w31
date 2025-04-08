package com.bootcamp.ejercicio_starwars.models;

import com.bootcamp.ejercicio_starwars.util.JsonDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Personaje {
    private String name;
    @Setter(AccessLevel.NONE)
    private Integer height;
    @Setter(AccessLevel.NONE)
    private Integer mass;
    @JsonProperty("hair_color")
    private String hairColor;
    @JsonProperty("skin_color")
    private String skinColor;
    @JsonProperty("eye_color")
    private String eyeColor;
    @JsonProperty("birth_year")
    private String birthDate;
    private String gender;
    private String homeworld;
    private String species;

    public void setHeight(String height) {
        this.height = JsonDeserializer.parseInteger(height);
    }

    public void setMass(String mass) {
        this.mass = JsonDeserializer.parseInteger(mass);
    }
}

package com.bootcamp.star_wars_pj.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Personaje {
    private String name, hair_color, skin_color, eye_color, birth_year, gender, homeworld, species;
    private String height, mass;
}

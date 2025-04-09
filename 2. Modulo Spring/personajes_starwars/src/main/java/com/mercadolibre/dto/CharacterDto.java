package com.mercadolibre.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDto implements Serializable {
    private String name;
    private String heigth;
    private String mass;
    private String gender;
    private String homeworld;
    private String species;
}

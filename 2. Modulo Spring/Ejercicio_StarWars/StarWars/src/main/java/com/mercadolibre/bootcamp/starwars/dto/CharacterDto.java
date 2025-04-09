package com.mercadolibre.bootcamp.starwars.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterDto {

    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;
}

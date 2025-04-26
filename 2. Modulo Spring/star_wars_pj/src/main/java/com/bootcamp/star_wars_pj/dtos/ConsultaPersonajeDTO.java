package com.bootcamp.star_wars_pj.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConsultaPersonajeDTO {
    private String name, gender, homeworld, species;
    private String height, mass;
}

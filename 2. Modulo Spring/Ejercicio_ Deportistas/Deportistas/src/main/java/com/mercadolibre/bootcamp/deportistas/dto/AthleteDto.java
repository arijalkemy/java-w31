package com.mercadolibre.bootcamp.deportistas.dto;

import com.mercadolibre.bootcamp.deportistas.model.Sport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class AthleteDto {
    private String name;
    private String lastName;
    private String sports;
}

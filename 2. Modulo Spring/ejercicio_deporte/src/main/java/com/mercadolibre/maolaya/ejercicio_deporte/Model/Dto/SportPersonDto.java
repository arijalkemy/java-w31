package com.mercadolibre.maolaya.ejercicio_deporte.Model.Dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class SportPersonDto implements Serializable {
    private String name;
    private String lastname;
    private String sport;
}

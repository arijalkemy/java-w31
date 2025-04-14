package com.miprimerproyecto.pruebaspring.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaSportDto {
    private String name;
    private String lastname;
    private String sportname;
}

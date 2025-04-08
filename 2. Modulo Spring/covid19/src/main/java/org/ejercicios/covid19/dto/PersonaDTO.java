package org.ejercicios.covid19.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonaDTO {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
}

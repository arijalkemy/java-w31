package com.mercadolibre.ejerciciodto.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO implements Serializable {
    private String nombre;
    private String apellido;
    private Deporte deporte;
}

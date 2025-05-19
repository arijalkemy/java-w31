package com.example.deportistas.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class DeporteDTO implements Serializable {
    private String nombre;
    private String apellido;
    private String deporte;
}

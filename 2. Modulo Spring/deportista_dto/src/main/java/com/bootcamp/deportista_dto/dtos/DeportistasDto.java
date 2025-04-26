package com.bootcamp.deportista_dto.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DeportistasDto implements Serializable {
    private String nombre;
    private String apellido;
    private String deporte;
}

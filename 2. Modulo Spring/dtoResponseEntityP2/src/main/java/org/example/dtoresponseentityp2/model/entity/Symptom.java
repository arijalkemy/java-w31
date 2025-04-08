package org.example.dtoresponseentityp2.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.dtoresponseentityp2.utilities.NIVEL_DE_GRAVEDAD;

@Getter
@Setter
@AllArgsConstructor
public class Sintoma {
    private String codigo;
    private String nombre;
    private NIVEL_DE_GRAVEDAD nivelDeGravedad;
}

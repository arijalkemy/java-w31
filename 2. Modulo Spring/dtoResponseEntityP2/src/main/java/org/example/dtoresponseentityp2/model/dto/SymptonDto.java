package org.example.dtoresponseentityp2.model.dto;

import lombok.AllArgsConstructor;
import org.example.dtoresponseentityp2.utilities.NIVEL_DE_GRAVEDAD;

import java.io.Serializable;

@AllArgsConstructor
public class SymptonDto implements Serializable {
    private String nombre;
    private NIVEL_DE_GRAVEDAD nivelDeGravedad;
}

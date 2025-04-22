package org.example.ejerciciosdtoresponseentityp2.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class PersonaDeporteDto implements Serializable {
    private String nombre;
    private String deporte;

    @Override
    public String toString() {
        return "PersonaDeporteDto{" +
                "nombre='" + nombre + '\'' +
                ", deporte='" + deporte + '\'' +
                '}';
    }
}

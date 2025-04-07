package org.mercadolibre.ejercicio_deportistas.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Deporte {
    private String nombre;
    private String nivel;

    public Deporte() {
    }

    public Deporte(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "Deporte{" +
                "nombre='" + nombre + '\'' +
                ", nivel='" + nivel + '\'' +
                '}';
    }
}

package org.mercadolibre.ejercicio_deportistas.models;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Persona {
    private String name;
    private String apellido;
    private int edad;

    public Persona() {
    }

    public Persona(String name, String apellido, int edad) {
        this.name = name;
        this.apellido = apellido;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                '}';
    }
}

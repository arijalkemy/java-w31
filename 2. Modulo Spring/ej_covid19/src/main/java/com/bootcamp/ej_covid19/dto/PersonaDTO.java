package com.bootcamp.ej_covid19.dto;

public class PersonaDTO {
    private String nombre;
    private String apellido;

    public PersonaDTO(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }
}

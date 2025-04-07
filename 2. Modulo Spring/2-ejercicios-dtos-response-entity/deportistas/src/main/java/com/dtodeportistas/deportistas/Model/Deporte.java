package com.dtodeportistas.deportistas.Model;

public class Deporte {
    private String nombre;
    private Integer nivel;

    public Deporte(String nombre, Integer nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getNivel() {
        return nivel;
    }
}

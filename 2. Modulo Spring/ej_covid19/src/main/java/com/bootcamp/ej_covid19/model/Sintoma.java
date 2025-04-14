package com.bootcamp.ej_covid19.model;

public class Sintoma {
    private String nombre;
    private String codigo;
    private String nivelDeGravedad;

    public Sintoma(String nombre, String codigo, String nivelDeGravedad) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.nivelDeGravedad = nivelDeGravedad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNivelDeGravedad() {
        return nivelDeGravedad;
    }
}

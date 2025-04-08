package com.bootcamp.ejerciciocovid19.entity;

public class Symptom {
    private String codigo;
    private String nombre;
    private String nivelDeGravedad;

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNivelDeGravedad() {
        return nivelDeGravedad;
    }

    public Symptom(String codigo, String nombre, String nivelDeGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }
}

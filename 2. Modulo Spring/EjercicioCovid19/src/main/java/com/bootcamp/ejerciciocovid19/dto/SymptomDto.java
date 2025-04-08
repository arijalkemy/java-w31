package com.bootcamp.ejerciciocovid19.dto;

public class SymptomDto {
    private String codigo;
    private String nombre;
    private String nivelDeGravedad;

    public SymptomDto(String codigo, String nombre, String nivelDeGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelDeGravedad = nivelDeGravedad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNivelDeGravedad() {
        return nivelDeGravedad;
    }
}

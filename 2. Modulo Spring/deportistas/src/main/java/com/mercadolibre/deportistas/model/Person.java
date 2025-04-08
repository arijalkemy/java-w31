package com.mercadolibre.deportistas.model;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String nombre;
    private String apellido;
    private Integer edad;
    private List<Sport> deportesPracticados;

    public Person(String nombre, String apellido, Integer edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        deportesPracticados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public List<Sport> getDeportesPracticados() {
        return deportesPracticados;
    }

    public void agregarDeporte(Sport sport) {
        this.deportesPracticados.add(sport);
    }

    public String[] deportesToString() {
        return deportesPracticados.stream().map(Sport::getNombre).toArray(String[]::new);
    }
}

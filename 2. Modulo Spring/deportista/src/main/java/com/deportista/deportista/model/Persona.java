package com.deportista.deportista.model;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private String nombre;
    private String apellido;
    private Integer edad;
    private List<Deporte> listaDeporte = new ArrayList<>();

    public Persona(String nombre, String apellido, Integer edad,List<Deporte> listaDeporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.listaDeporte = listaDeporte;
    }

    public List<Deporte> getListaDeporte() {
        return listaDeporte;
    }

    public void setListaDeporte(List<Deporte> listaDeporte) {
        this.listaDeporte = listaDeporte;
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
}

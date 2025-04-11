package com.example;

public class Persona {
    private String nombre;
    private String apellidos;
    private String[] habilidades;

    public Persona(String nombre, String apellidos, String[] habilidades) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String[] getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String[] habilidades) {
        this.habilidades = habilidades;
    }

}
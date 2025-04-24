package com.fernandotorres.dtoyresponseentity.model;

import java.util.Objects;

public class Persona {

    private String Nombre;
    private String Apellido;
    private int Edad;

    public Persona(String nombre, String apellido, int edad) {
        Nombre = nombre;
        Apellido = apellido;
        Edad = edad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", Edad=" + Edad +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Edad == persona.Edad && Objects.equals(Nombre, persona.Nombre) && Objects.equals(Apellido, persona.Apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Nombre, Apellido, Edad);
    }

}

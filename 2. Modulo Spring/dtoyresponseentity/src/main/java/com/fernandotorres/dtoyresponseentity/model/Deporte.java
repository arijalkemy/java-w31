package com.fernandotorres.dtoyresponseentity.model;

import java.util.Objects;

public class Deporte {

    private String Nombre;
    private int Nivel;

    public Deporte(String nombre, int nivel) {
        Nombre = nombre;
        Nivel = nivel;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getNivel() {
        return Nivel;
    }

    public void setNivel(int nivel) {
        Nivel = nivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deporte deporte = (Deporte) o;
        return Nivel == deporte.Nivel && Objects.equals(Nombre, deporte.Nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Nombre, Nivel);
    }

    @Override
    public String toString() {
        return "Deporte{" +
                "Nombre='" + Nombre + '\'' +
                ", Nivel=" + Nivel +
                '}';
    }
}

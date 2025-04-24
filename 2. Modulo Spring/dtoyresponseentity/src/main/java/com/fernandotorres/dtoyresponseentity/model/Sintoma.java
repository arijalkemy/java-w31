package com.fernandotorres.dtoyresponseentity.model;

import java.util.Objects;

public class Sintoma {
    private int codigo;
    private String nombre;
    private int nivel_de_gravedad;

    public Sintoma(int codigo, String nombre, int nivel_de_gravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel_de_gravedad = nivel_de_gravedad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel_de_gravedad() {
        return nivel_de_gravedad;
    }

    public void setNivel_de_gravedad(int nivel_de_gravedad) {
        this.nivel_de_gravedad = nivel_de_gravedad;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sintoma sintoma = (Sintoma) o;
        return codigo == sintoma.codigo && nivel_de_gravedad == sintoma.nivel_de_gravedad && Objects.equals(nombre, sintoma.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, nivel_de_gravedad);
    }

    @Override
    public String toString() {
        return "Sintoma{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", nivel_de_gravedad=" + nivel_de_gravedad +
                '}';
    }

}



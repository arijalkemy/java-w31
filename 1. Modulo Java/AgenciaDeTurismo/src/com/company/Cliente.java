package com.company;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String dni,nombre, apellido;
    private Boolean descuentox2Localizadores;

    public Cliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Boolean getDescuentox2Localizadores() {
        return descuentox2Localizadores;
    }

    public void setDescuentox2Localizadores(Boolean descuentox2Localizadores) {
        this.descuentox2Localizadores = descuentox2Localizadores;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    @Override
    public String toString() {
        return "Cliente{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }


}

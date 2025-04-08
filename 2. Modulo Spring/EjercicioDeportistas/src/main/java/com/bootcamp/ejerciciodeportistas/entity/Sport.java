package com.bootcamp.ejerciciodeportistas.entity;

import lombok.Data;
import lombok.Getter;

@Data
public class Sport {
    private String nombre;
    private String nivel;

    public String getNombre() {
        return nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public Sport(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }
}

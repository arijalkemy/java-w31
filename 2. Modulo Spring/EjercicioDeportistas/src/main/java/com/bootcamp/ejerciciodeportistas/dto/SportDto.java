package com.bootcamp.ejerciciodeportistas.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class SportDto {
    private String nombre;
    private String nivel;

    public SportDto(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNivel() {
        return nivel;
    }
}

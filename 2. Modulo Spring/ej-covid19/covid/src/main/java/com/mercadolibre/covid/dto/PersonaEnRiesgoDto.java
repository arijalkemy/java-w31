package com.mercadolibre.covid.dto;

public class PersonaEnRiesgoDto {
    private String nombreCompleto;

    public PersonaEnRiesgoDto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}

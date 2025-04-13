package com.mercadolibre.covid.model;

import com.mercadolibre.covid.dto.PersonaEnRiesgoDto;

public class PersonaEnRiesgo extends Persona {
    private Sintoma[] sintomas;

    public PersonaEnRiesgo(String id, String nombre, String apellido, int edad, Sintoma[] sintomas) {
        super(id, nombre, apellido, edad);
        this.sintomas = sintomas;
    }

    public Sintoma[] getSintomas() {
        return sintomas;
    }

    public void setSintomas(Sintoma[] sintomas) {
        this.sintomas = sintomas;
    }

    public PersonaEnRiesgoDto toDto() {
        return new PersonaEnRiesgoDto(this.getNombre() + " " + this.getApellido());
    }
}

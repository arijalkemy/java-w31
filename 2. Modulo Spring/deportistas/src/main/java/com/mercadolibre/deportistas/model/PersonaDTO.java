package com.mercadolibre.deportistas.model;

import java.io.Serializable;

public class PersonaDTO implements Serializable {
    private String fullName;
    private String[] deportes;

    public PersonaDTO(String fullName, String[] deportes) {
        this.fullName = fullName;
        this.deportes = deportes;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String[] getDeportes() {
        return deportes;
    }

    public void setDeportes(String[] deportes) {
        this.deportes = deportes;
    }
}

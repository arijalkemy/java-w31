package com.mercadolibre.deportistas.dto;

import java.io.Serializable;

public class PersonDTO implements Serializable {
    private String fullName;
    private String[] deportes;

    public PersonDTO(String fullName, String[] deportes) {
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

package com.example.ejercicioDeportistas.dto;

import java.io.Serializable;

public class SportPersonDTO implements Serializable {
    private String name;
    private String lastname;
    private String sportName;

    public SportPersonDTO(String name, String lastname, String sportName) {
        this.name = name;
        this.lastname = lastname;
        this.sportName = sportName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getSportName() {
        return sportName;
    }
}

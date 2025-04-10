package com.mercadolibre.deportista.dto;


import lombok.Data;

@Data
public class PersonDTO {
    private String name;
    private String surname;
    private String sportName;

    public PersonDTO() {
    }

    public PersonDTO(String name, String surname, String sportName) {
        this.name = name;
        this.surname = surname;
        this.sportName = sportName;
    }

}

package com.bootcamp.ejercicio_deportistas.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PersonSportDto implements Serializable {
    private String name;
    private String lastname;
    private Integer age;
    private List<SportDto> sports;
}

package com.bootcamp.ejercicio_deportistas.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SportDto implements Serializable {
    private String name;
    private Integer level;
}

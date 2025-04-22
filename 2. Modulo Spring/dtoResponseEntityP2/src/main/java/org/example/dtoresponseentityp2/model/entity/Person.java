package org.example.dtoresponseentityp2.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
}

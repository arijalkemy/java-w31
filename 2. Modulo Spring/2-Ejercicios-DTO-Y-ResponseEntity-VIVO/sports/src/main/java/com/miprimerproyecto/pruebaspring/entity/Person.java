package com.miprimerproyecto.pruebaspring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Person {
    private String name;
    private String lastname;
    private Integer age; 
}

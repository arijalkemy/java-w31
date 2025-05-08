package com.spring.ejerciciodeportistas.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Person {
    private String name;
    private String surname;
    private int yearsOld;
    private Sport sport;
}

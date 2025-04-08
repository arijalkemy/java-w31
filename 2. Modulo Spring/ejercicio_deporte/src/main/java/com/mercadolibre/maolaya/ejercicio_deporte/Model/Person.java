package com.mercadolibre.maolaya.ejercicio_deporte.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Person {
    private String name;
    private String lastname;
    private String age;
    private Sport sport;
}

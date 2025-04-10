package com.mercadolibre.deportista.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String name;
    private String surname;
    private int age;
    private Sport sport;

    public Person() {
    }

    public Person(String name, String surname, int age, Sport sport) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sport = sport;
    }


}

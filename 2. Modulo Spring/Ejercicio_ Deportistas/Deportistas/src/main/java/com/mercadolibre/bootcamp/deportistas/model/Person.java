package com.mercadolibre.bootcamp.deportistas.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Person {

    private String name;
    private String lastName;
    private String age;
    private List<Sport> sports;

    public Person(String name, String lastName, String age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sports = new ArrayList<>();
    }

    public Person(String name, String lastName, String age, List<Sport> sports) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.sports = sports;
    }

    public void addSport(Sport sport) {
        this.sports.add(sport);
    }
}

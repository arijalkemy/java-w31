package com.example.Covid.Entities;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String name;
    private String lastName;
    private int age;
    private static int counter = 0;
    private int id;

    public Person(String name, String lastName, int age) {
        this.id = ++counter;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public List<Symptom> getSymptoms() {
        return null;
    }
}

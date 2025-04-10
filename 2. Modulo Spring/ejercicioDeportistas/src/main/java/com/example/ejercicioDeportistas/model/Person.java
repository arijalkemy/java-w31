package com.example.ejercicioDeportistas.model;

public class Person {
    private String name;
    private String lastname;
    private Integer age;

    public Person(String name, String lastname, Integer age) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public Integer getAge() {
        return age;
    }
}

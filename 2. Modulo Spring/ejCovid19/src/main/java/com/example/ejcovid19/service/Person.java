package com.example.ejcovid19.service;

import lombok.Getter;

public class Person {
    @Getter
    private Integer id;
    @Getter
    private String name;
    @Getter
    private String lastname;
    @Getter
    private Integer age;

    public Person(Integer id, String name, String lastname, Integer age) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
    }
}

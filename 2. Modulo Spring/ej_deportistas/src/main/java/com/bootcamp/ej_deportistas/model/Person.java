package com.bootcamp.ej_deportistas.model;
import java.util.List;

public class Person {
    private String name;
    private String surname;
    private int age;
    private List<Sport> sports;

    public Person(String name, String apellido, int age, List<Sport> sports) {
        this.name = name;
        this.surname = apellido;
        this.age = age;
        this.sports = sports;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public List<Sport> getSports() {
        return sports;
    }
}

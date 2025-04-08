package com.bootcamp.ejercicio_covid19.dto;

import com.bootcamp.ejercicio_covid19.model.Symptom;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonDto implements Serializable {
    private Integer id;
    private String name;
    private String lastName;
    private Integer age;
    private List<Symptom> symptoms;

    public PersonDto(Integer id, String name, String lastName, Integer age, List<Symptom> symptoms) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.symptoms = symptoms;
    }

    public PersonDto(String name, String lastName, Integer age, List<Symptom> symptoms) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.symptoms = symptoms;
    }

    public PersonDto(String name, String lastName, Integer age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<Symptom> symptoms) {
        this.symptoms = symptoms;
    }
}

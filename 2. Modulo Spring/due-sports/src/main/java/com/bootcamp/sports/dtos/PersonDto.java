package com.bootcamp.sports.dtos;

import com.bootcamp.sports.models.Person;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonDto implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String sportName;
    private Integer sportLevel;

    private PersonDto(Long id, String firstName, String lastName, Integer age, String sportName, Integer sportLevel) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sportName = sportName;
        this.sportLevel = sportLevel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) { this.age = age; }
    
    public void setSportName(String sportName) {
        this.sportName = sportName;
    }

    public void setSportLevel(Integer sportLevel) {
        this.sportLevel = sportLevel;
    }
    
    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public Integer getAge() { return age; }

    public String getSportName() {
        return sportName;
    }

    public Integer getSportLevel() {
        return sportLevel;
    }

    public static PersonDto buildFromPerson(Person person) {
        return new PersonDto(person.getId(),
                person.getFirstName(),
                person.getLastName(),
                null,
                person.getSport().getName(),
                null);
    }
}

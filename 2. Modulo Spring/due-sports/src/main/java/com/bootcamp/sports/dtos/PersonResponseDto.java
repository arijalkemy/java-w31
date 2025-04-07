package com.bootcamp.sports.dtos;

import com.bootcamp.sports.models.Person;

import java.io.Serializable;

public class PersonResponseDto implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String sport;

    private PersonResponseDto(Long id, String firstName, String lastName, String sport) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sport = sport;
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

    public void setSport(String sport) {
        this.sport = sport;
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

    public String getSport() {
        return sport;
    }

    public static PersonResponseDto buildFromPerson(Person person) {
        return new PersonResponseDto(person.getId(),
                person.getFirstName(),
                person.getLastName(),
                person.getSport().getName());
    }
}

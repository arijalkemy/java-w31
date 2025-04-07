package com.bootcamp.sports.models;

import com.bootcamp.sports.dtos.PersonDto;
import com.bootcamp.sports.services.SportsService;

public class Person {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Sport sport;
    private static long idsCounter = 0;

    public Person(String firstName, String lastName, Integer age, Sport sport) {
        idsCounter++;
        this.id = idsCounter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sport = sport;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public Sport getSport() {
        return sport;
    }

    public Long getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public static Person buildFromDto(PersonDto personDto) {
        Sport sport = SportsService.getSportByName(personDto.getSportName());

        if (sport != null) {
            return new Person(personDto.getFirstName(), personDto.getLastName(), personDto.getAge(), sport);
        } else {
            Sport newSport = new Sport(personDto.getSportName(), personDto.getSportLevel());
            SportsService.addSport(newSport);
            return new Person(personDto.getFirstName(),
                    personDto.getLastName(),
                    personDto.getAge(),
                    newSport);
        }
    }

    @Override
    public String toString() {
        return "\nPerson:" +
                "\n\tid= " + id +
                "\n\tfirstName= " + firstName +
                "\n\tlastName= " + lastName +
                "\n\tage= " + age +
                "\n\tsport= " + sport;
    }
}

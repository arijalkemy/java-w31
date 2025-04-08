package com.bootcamp.sports.services;

import com.bootcamp.sports.dtos.PersonDto;
import com.bootcamp.sports.models.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonService {
    private static List<Person> persons = new ArrayList<>();

    public static List<PersonDto> getPersons() {
        return persons.stream().map(PersonDto::buildFromPerson).collect(Collectors.toList());
    }

    public static PersonDto addPerson(PersonDto personDto) {
        if (personDto != null) {
            Person person = Person.buildFromDto(personDto);
            persons.add(person);
            return PersonDto.buildFromPerson(person);
        }
        return null;
    }
}

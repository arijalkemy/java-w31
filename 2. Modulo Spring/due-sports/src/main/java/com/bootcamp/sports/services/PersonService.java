package com.bootcamp.sports.services;

import com.bootcamp.sports.models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonService {
    private static List<Person> persons = new ArrayList<>();

    public static List<Person> getPersons() {
        return persons;
    }

    public static void addPerson(Person person) {
        if (person != null) {
            persons.add(person);
        }
    }
}

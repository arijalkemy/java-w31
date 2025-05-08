package com.spring.ejerciciodeportistas.repository;

import com.spring.ejerciciodeportistas.model.Person;
import com.spring.ejerciciodeportistas.model.Sport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository {
    private static List<Person> people = new ArrayList<>();

    static {
        Sport volleyball = new Sport("Volleyball", "High");
        Sport basketball = new Sport("Basketball", "Medium");

        people.add(new Person("Jane", "Doe", 25, volleyball));
        people.add(new Person("John", "Doe", 30, basketball));
    }

    public List<Person> findAll() {
        return people;
    }
}

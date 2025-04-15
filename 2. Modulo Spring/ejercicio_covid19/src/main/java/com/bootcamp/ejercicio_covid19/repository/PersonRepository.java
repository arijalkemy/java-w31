package com.bootcamp.ejercicio_covid19.repository;

import com.bootcamp.ejercicio_covid19.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository implements IPersonRepository {
    private final List<Person> persons = new ArrayList<>();
    @Override
    public void saveAll(List<Person> persons) {
        this.persons.addAll(persons);
    }

    @Override
    public List<Person> getRiskPerson() {
        return persons.stream().filter(person -> person.getAge() > 60 && !person.getSymptoms().isEmpty()).toList();
    }
}

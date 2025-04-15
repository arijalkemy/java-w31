package com.bootcamp.ejercicio_covid19.repository;

import com.bootcamp.ejercicio_covid19.model.Person;

import java.util.List;

public interface IPersonRepository {
    void saveAll(List<Person> persons);

    List<Person> getRiskPerson();
}

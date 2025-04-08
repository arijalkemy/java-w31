package com.bootcamp.ejerciciodeportistas.repository;

import com.bootcamp.ejerciciodeportistas.entity.Person;

import java.util.List;

public interface IPersonRepository {
    public List<Person> allPersons();
}

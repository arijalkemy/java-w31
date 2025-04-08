package com.bootcamp.ejerciciodeportistas.repository;

import com.bootcamp.ejerciciodeportistas.entity.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonRepository implements IPersonRepository {
    private List<Person> listOfPeople = new ArrayList<>();
    public PersonRepository() throws IOException {
        loadDataBase();
    }

    @Override
    public List<Person> allPersons() {
        return listOfPeople;
    }

    private void loadDataBase() throws IOException {
        List<Person> person = new ArrayList<>();

        person.add(new Person("Nicolas", "Cundari", 30));

        listOfPeople = person;
    }
}

package com.bootcamp.ejercicio_deportistas.repository;


import com.bootcamp.ejercicio_deportistas.model.Person;
import com.bootcamp.ejercicio_deportistas.model.Sport;

import java.util.List;

public interface ISportRepository {

    List<Sport> getAll();

    Sport getByName(String name);

    List<Person> getSportPersons();
}

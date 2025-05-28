package com.sports.demo.repository;

import java.util.List;
import java.util.Optional;

import com.sports.demo.entity.Person;
import com.sports.demo.entity.Sport;



public interface ISportRepository {
    List<Sport> getSports();
    Optional<Sport> getByName(String name);
    List<Person> getSportsPersons();
    





}

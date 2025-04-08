package com.mercadolibre.deportistas.repository;


import com.mercadolibre.deportistas.Dto.PersonDTO;
import com.mercadolibre.deportistas.model.Person;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PersonRepository {
    private List<Person> persons;
    private final SportsRepository sportRepository;

    public PersonRepository() {
        persons = new ArrayList<>();
        persons.add(new Person("John", "Doe", 30, List.of("Futbol", "Natación", "Tennis")));
        persons.add(new Person("Jane", "Smith", 25, List.of("Tennis", "Futbol")));
        persons.add(new Person("Alice", "Johnson", 40, List.of("Tennis", "Natación")));
        sportRepository = new SportsRepository();
    }

    public List<com.mercadolibre.deportistas.Dto.PersonDTO> getPersonsAndSports() {
        return (List<com.mercadolibre.deportistas.Dto.PersonDTO>) persons.stream()
                .map(person -> {
                    person.getSports().stream().map(t -> {
                        sportRepository.getAllSports();
                        return false;
                    }).toList();
                    return new com.mercadolibre.deportistas.Dto.PersonDTO(person.getName(), person.getLastName(), person.getSports());
                }).collect(Collectors.toList());
    }


}

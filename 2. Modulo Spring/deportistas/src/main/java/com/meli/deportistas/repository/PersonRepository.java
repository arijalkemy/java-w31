package com.meli.deportistas.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.meli.deportistas.dto.PersonDTO;
import com.meli.deportistas.model.PersonModel;
import com.meli.deportistas.model.SportModel;

@Repository
public class PersonRepository {
    private List<PersonModel> persons;
    private final SportRepository sportRepository;

    public PersonRepository() {
        persons = new ArrayList<>();
        persons.add(new PersonModel("John", "Doe", 30, new HashSet<>(Arrays.asList(1, 2))));
        persons.add(new PersonModel("Jane", "Smith", 25, new HashSet<>(Arrays.asList(1, 2))));
        persons.add(new PersonModel("Alice", "Johnson", 40, new HashSet<>(Arrays.asList(1, 2))));

        sportRepository = new SportRepository();
    }

    public List<SportModel> getPersonSports(PersonModel person) {
        return person.getDeportesIds().stream()
                .map(sportRepository::getSportById)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    public List<PersonDTO> getPersonsAndSports() {
        return persons.stream()
                .map(person -> {
                    List<SportModel> sports = getPersonSports(person);
                    List<String> sportNames = sports.stream()
                            .map(SportModel::getName)
                            .collect(Collectors.toList());
                    return new PersonDTO(person.getFirstName(), person.getLastName(), sportNames);
                })
                .collect(Collectors.toList());
    }
}

package com.spring.ejerciciodeportistas.service;

import com.spring.ejerciciodeportistas.model.SportPersonDTO;
import com.spring.ejerciciodeportistas.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<SportPersonDTO> getSportsPerson() {
        return personRepository.findAll().stream()
                .map(p -> new SportPersonDTO(p.getName(), p.getSurname(), p.getSport().getName()))
                .collect(Collectors.toList());
    }
}

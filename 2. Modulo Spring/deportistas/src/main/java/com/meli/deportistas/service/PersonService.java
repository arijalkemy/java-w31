package com.meli.deportistas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meli.deportistas.dto.PersonDTO;
import com.meli.deportistas.repository.PersonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public List<PersonDTO> getPersonsAndSports() {
        return personRepository.getPersonsAndSports();
    }
}

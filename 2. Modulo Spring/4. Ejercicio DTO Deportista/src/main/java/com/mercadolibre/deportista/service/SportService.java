package com.mercadolibre.deportista.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.deportista.dto.PersonDTO;
import com.mercadolibre.deportista.dto.SportDTO;
import com.mercadolibre.deportista.model.Sport;
import com.mercadolibre.deportista.repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SportService {

    @Autowired
    private DataRepository dataRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public List<SportDTO> getAllSports() {
        return dataRepository.getSports().stream()
                // Convert Sport entity to SportDTO
                .map(sport -> objectMapper.convertValue(sport, SportDTO.class))
                .collect(Collectors.toList());
    }

    public Sport getSportByName(String name) {
        return dataRepository.findSportByName(name);
    }

    public List<PersonDTO> getAllSportPersons() {
        return dataRepository.getPersons().stream()
                .map(person -> new PersonDTO(
                        person.getName(),
                        person.getSurname(),
                        person.getSport().getName()))
                .collect(Collectors.toList());
    }
}

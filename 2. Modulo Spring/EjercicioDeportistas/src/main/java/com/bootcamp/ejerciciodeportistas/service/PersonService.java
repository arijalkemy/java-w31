package com.bootcamp.ejerciciodeportistas.service;

import com.bootcamp.ejerciciodeportistas.dto.PersonDto;
import com.bootcamp.ejerciciodeportistas.entity.Person;
import com.bootcamp.ejerciciodeportistas.exception.NotFoundException;
import com.bootcamp.ejerciciodeportistas.repository.IPersonRepository;
import com.bootcamp.ejerciciodeportistas.repository.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService implements IPersonService {
    IPersonRepository personaRepository;
    public PersonService(PersonRepository personRepository){
        this.personaRepository = personRepository;
    }

    @Override
    public List<PersonDto> getAllPersons() {
        List<Person> people = personaRepository.allPersons();
        if(people.isEmpty()){
            throw new NotFoundException("No se encontro ninguna persona.");
        }
        return people.stream()
                .map(v -> new PersonDto(v.getNombre(), v.getApellido(), v.getEdad()))
                .collect(Collectors.toList());
    }
}

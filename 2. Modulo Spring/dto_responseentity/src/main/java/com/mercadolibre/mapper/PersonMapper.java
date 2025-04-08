package com.mercadolibre.mapper;

import com.mercadolibre.model.Person;
import com.mercadolibre.model.dto.PersonDto;

public class PersonMapper {
    public static PersonDto personToPersonDto(Person person){
        return new PersonDto(person.getName(), person.getLastName());
    }

    public static Person personDtoToPerson(PersonDto personDto){
        Person person = new Person();
        person.setName(personDto.getName());
        person.setLastName(personDto.getLastName());
        return person;
    }
}

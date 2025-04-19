package com.mercadolibreexample.starwarnames.Mapper;

import com.mercadolibreexample.starwarnames.Entity.Personaje;
import com.mercadolibreexample.starwarnames.dto.PersonajeDto;

public class PersonajeMapper {
    static public PersonajeDto toPersonajeDto (Personaje personaje){
        PersonajeDto personajeDto = new PersonajeDto();
        personajeDto.setName(personaje.getName());
        personajeDto.setHeight(personaje.getHeight());
        personajeDto.setMass(personaje.getMass());
        personajeDto.setGender(personaje.getGender());
        personajeDto.setHomeworld(personaje.getHomeworld());
        personajeDto.setSpecies(personaje.getSpecies());
        return personajeDto;
    }
}

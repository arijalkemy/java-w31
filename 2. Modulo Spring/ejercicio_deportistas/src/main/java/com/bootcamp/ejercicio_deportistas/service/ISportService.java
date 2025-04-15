package com.bootcamp.ejercicio_deportistas.service;

import com.bootcamp.ejercicio_deportistas.dto.PersonSportDto;
import com.bootcamp.ejercicio_deportistas.dto.SportDto;

import java.util.List;

public interface ISportService {
    List<SportDto> getAll();

    SportDto getByName(String name);

    List<PersonSportDto> getSportPersons();

}

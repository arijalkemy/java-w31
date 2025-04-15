package com.bootcamp.ejercicio_covid19.service;

import com.bootcamp.ejercicio_covid19.dto.PersonDto;

import java.util.List;

public interface IPersonService {
    List<PersonDto> getRiskPersons();
}

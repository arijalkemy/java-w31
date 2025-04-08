package com.bootcamp.ejerciciodeportistas.service;

import com.bootcamp.ejerciciodeportistas.dto.PersonDto;

import java.util.List;

public interface IPersonService {
    List<PersonDto> getAllPersons();
}

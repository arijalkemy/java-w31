package com.mercadolibre.service;

import com.mercadolibre.model.PersonDto;

import java.util.List;

public interface IPersonService {

    List<PersonDto> findAll();

    PersonDto findByName(String name);
}

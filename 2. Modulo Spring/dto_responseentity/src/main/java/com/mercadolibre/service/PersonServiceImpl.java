package com.mercadolibre.service;

import com.mercadolibre.model.PersonDto;

import java.util.List;


public class PersonServiceImpl implements IPersonService{


    @Override
    public List<PersonDto> findAll() {
        return List.of();
    }

    @Override
    public PersonDto findByName(String name) {
        return null;
    }
}

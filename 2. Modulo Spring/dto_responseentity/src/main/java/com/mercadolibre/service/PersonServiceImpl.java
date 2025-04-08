package com.mercadolibre.service;

import com.mercadolibre.model.dto.PersonDto;
import com.mercadolibre.model.dto.SportDto;
import com.mercadolibre.model.dto.SportsManDto;
import org.springframework.stereotype.Service;

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

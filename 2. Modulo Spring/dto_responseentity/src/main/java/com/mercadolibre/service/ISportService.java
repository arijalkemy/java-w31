package com.mercadolibre.service;

import com.mercadolibre.model.SportDto;
import com.mercadolibre.model.SportsManDto;

import java.util.List;


public interface ISportService {

    List<SportDto> findAll();

    SportDto findByName(String name);

    List<SportsManDto> findSoportsAndPersons();
}

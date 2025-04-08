package com.mercadolibre.service;

import com.mercadolibre.model.dto.SportDto;
import com.mercadolibre.model.dto.SportsManDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ISportService {

    List<SportDto> findAll();

    SportDto findByName(String name);

    List<SportsManDto> findSoportsAndPersons();
}

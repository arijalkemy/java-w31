package com.bootcamp.ejercicio_covid19.service;

import com.bootcamp.ejercicio_covid19.dto.SymptomDto;

import java.util.List;

public interface ISymptomService {
    List<SymptomDto> getAll();
    SymptomDto findByName(String name);
}

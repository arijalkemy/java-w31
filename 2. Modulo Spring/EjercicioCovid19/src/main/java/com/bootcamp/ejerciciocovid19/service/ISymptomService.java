package com.bootcamp.ejerciciocovid19.service;

import com.bootcamp.ejerciciocovid19.dto.SymptomDto;
import com.bootcamp.ejerciciocovid19.exception.NotFoundException;

import java.util.List;

public interface ISymptomService {
    public List<SymptomDto> allSymptoms();

    public SymptomDto findSymptom(String name) throws NotFoundException;
}

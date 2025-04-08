package com.bootcamp.ejerciciocovid19.service;

import com.bootcamp.ejerciciocovid19.dto.SymptomDto;
import com.bootcamp.ejerciciocovid19.entity.Symptom;
import com.bootcamp.ejerciciocovid19.exception.NotFoundException;
import com.bootcamp.ejerciciocovid19.repository.ISymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SymptomService implements ISymptomService {
    @Autowired
    ISymptomRepository symptomRepository;
    @Override
    public List<SymptomDto> allSymptoms() {
        List<SymptomDto> allSymptoms = symptomRepository.allSymptoms().stream().map( s -> new SymptomDto(s.getCodigo()
                , s.getNombre(), s.getNivelDeGravedad())).collect(Collectors.toList());
        return allSymptoms;
    }
    @Override
    public SymptomDto findSymptom(String name) throws NotFoundException {
        Optional<Symptom> optionalSymptom = symptomRepository.findSymptom(name);
        if(!optionalSymptom.isPresent()){
            throw new NotFoundException("No se encontro el sintoma");
        }
        Symptom symptom = optionalSymptom.get();
        return new SymptomDto(symptom.getCodigo(), symptom.getNombre(), symptom.getNivelDeGravedad());
    }
}

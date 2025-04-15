package com.bootcamp.ejercicio_deportistas.service;

import com.bootcamp.ejercicio_deportistas.dto.PersonSportDto;
import com.bootcamp.ejercicio_deportistas.dto.SportDto;
import com.bootcamp.ejercicio_deportistas.repository.ISportRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportService implements ISportService{
    @Autowired
    private ISportRepository sportRepository;

    @Override
    public List<SportDto> getAll() {
        return new ObjectMapper().convertValue(sportRepository.getAll(), new TypeReference<List<SportDto>>() {});
    }

    @Override
    public SportDto getByName(String name) {
        return new ObjectMapper().convertValue(sportRepository.getByName(name), SportDto.class);
    }

    @Override
    public List<PersonSportDto> getSportPersons() {
        return new ObjectMapper().convertValue(sportRepository.getSportPersons(), PersonSportDto.class);
    }
}

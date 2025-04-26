package com.bootcamp.star_wars_pj.services;

import com.bootcamp.star_wars_pj.dtos.ConsultaPersonajeDTO;
import com.bootcamp.star_wars_pj.entity.Personaje;
import com.bootcamp.star_wars_pj.repository.IStarWarsRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StarWarsServiceImpl implements IStarWarsService{
    @Autowired
    IStarWarsRepository starWarsRepository;

    @Override
    public List<ConsultaPersonajeDTO> searchPersonajes(String query){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<Personaje> starwarsList = starWarsRepository.findAll();
        return starwarsList.stream().filter(p -> p.getName().toLowerCase().contains(query))
                .map(p -> mapper.convertValue(p, ConsultaPersonajeDTO.class))
                .collect(Collectors.toList());
    }
}

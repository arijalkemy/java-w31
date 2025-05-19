package com.example.deportistas.service;

import com.example.deportistas.dto.DeporteDTO;
import com.example.deportistas.repository.PersonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService {
    private final PersonaRepository personaRepository;

    public PersonaService(PersonaRepository personaRepository){
        this.personaRepository = personaRepository;
    }

    public List<DeporteDTO> getDeporte(){
        return personaRepository.findAll().stream()
                .map(p-> new DeporteDTO(p.getNombre(), p.getApellido()
                , p.getDeporte().getNombre()))
                .collect(Collectors.toList());
    }
}

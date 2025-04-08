package org.ejercicios.covid19.service;

import org.ejercicios.covid19.controller.Covid19Controller;
import org.ejercicios.covid19.dto.PersonaDTO;
import org.ejercicios.covid19.dto.SintomaDTO;
import org.ejercicios.covid19.model.Persona;
import org.ejercicios.covid19.model.Sintoma;
import org.ejercicios.covid19.repository.CovidRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Covid19Service {

    private CovidRepository repository;

    public Covid19Service(CovidRepository repository) {
        this.repository = repository;
    }

    public SintomaDTO getSintomaByName(String s) {
        Sintoma sintoma = repository.getSintomaByCodigo(s);
        return new SintomaDTO(sintoma.getCodigo(), sintoma.getNombre(), sintoma.getNivelDeGravedad());
    }

    public List<SintomaDTO> getSintomas() {
        List<Sintoma> sintomas = repository.getAllSintomas();
        return sintomas.stream().map(s -> new SintomaDTO(s.getCodigo(), s.getNombre(), s.getNivelDeGravedad())).toList();
    }

    public List<PersonaDTO> getPersonasInRisk() {
        // Esta logica tendria que estar en la query a la db.
        List<Persona> personas = repository.getAllPersonas();
        return personas.stream().filter(p -> p.getEdad() > 60).map(p -> new PersonaDTO(p.getId(), p.getNombre(), p.getApellido(), p.getEdad())).toList();
    }
}

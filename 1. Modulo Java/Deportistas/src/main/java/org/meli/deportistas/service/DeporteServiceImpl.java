package org.meli.deportistas.service;

import org.meli.deportistas.dto.PersonaDeportistaDTO;
import org.meli.deportistas.model.entity.Deporte;
import org.meli.deportistas.model.entity.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DeporteServiceImpl implements IDeporteService{

    private List<Deporte> deportes = new ArrayList<>();
    private List<Persona> personas = new ArrayList<>();

    public DeporteServiceImpl() {
        Deporte futbol = new Deporte("Fútbol", "Básico");
        Deporte beisbol = new Deporte("Béisbol", "Intermedio");
        Deporte basquetbol = new Deporte("Básquetbol", "Avanzado");

        deportes.add(futbol);
        deportes.add(beisbol);
        deportes.add(basquetbol);

        personas.add(new Persona("Juan", "López", 25, futbol));
        personas.add(new Persona("Ana", "Gómez", 26, beisbol));
        personas.add(new Persona("Angel", "Arellano", 27, basquetbol));
    }

    @Override
    public List<Deporte> getAllSports() {
        return deportes;
    }

    @Override
    public Optional<Deporte> getSportByName(String nombre) {
        return deportes.stream()
                .filter(deporte -> deporte.getNombre().equals(nombre)).findFirst();
    }

    @Override
    public List<PersonaDeportistaDTO> getPersonasDeportistas() {
        return personas.stream()
                .map(personasDeportistas -> new PersonaDeportistaDTO(personasDeportistas.getNombre(),
                        personasDeportistas.getApellido(), personasDeportistas.getDeporte().getNombre()))
                .collect(Collectors.toList());
    }
}
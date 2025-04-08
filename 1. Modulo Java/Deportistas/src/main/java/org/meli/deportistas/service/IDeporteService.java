package org.meli.deportistas.service;

import org.meli.deportistas.dto.PersonaDeportistaDTO;
import org.meli.deportistas.model.entity.Deporte;

import java.util.List;
import java.util.Optional;

public interface IDeporteService {
    public List<Deporte> getAllSports();
    public Optional<Deporte> getSportByName(String nombre);
    public List<PersonaDeportistaDTO> getPersonasDeportistas();
}

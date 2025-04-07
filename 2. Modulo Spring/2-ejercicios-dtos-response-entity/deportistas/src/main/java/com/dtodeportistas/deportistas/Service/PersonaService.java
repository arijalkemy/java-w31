package com.dtodeportistas.deportistas.Service;

import com.dtodeportistas.deportistas.DTO.PersonaDTO;
import com.dtodeportistas.deportistas.Model.Persona;
import com.dtodeportistas.deportistas.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public List<PersonaDTO> getPersonas() {
        List<Persona> personas = personaRepository.getPersonas();

        return personas.stream()
                .map(p -> new PersonaDTO(p.getNombre(), p.getApellido(), p.getDeporte().getNombre()))
                .toList();
    }

}

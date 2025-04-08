package org.mercadolibre.ejercicio_starwars.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.mercadolibre.ejercicio_starwars.dto.PersonajeDTO;
import org.mercadolibre.ejercicio_starwars.entity.Personaje;
import org.mercadolibre.ejercicio_starwars.exceptions.NotFoundException;
import org.mercadolibre.ejercicio_starwars.repository.IPersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonajeService implements IPersonajeService {

    IPersonajeRepository personajeRepository ;

    public PersonajeService(IPersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    public List<PersonajeDTO> listarPersonajes() {
        ObjectMapper mapper = new ObjectMapper();
        List<Personaje> personajes = personajeRepository.findAll();

        if(personajes.isEmpty()){
            throw new NotFoundException("No se encontraron personajes.");
        }

        return personajes.stream()
                .map(v -> mapper.convertValue(v,PersonajeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonajeDTO> listarPersonajesPorNombre(String nombre) {
        ObjectMapper mapper = new ObjectMapper();
        List<Personaje> personajes = personajeRepository.findAll();

        if(personajes.isEmpty()) {
            throw new NotFoundException("No se encontraron personajes.");
        }

        List<Personaje> personajesPorNombre = personajes.stream().filter( p -> p.getName().contains(nombre))
                .toList();

        if(personajesPorNombre.isEmpty()) {
            throw new NotFoundException("No se encontraron personajes.");
        }

        return personajesPorNombre.stream().map(v -> mapper.convertValue(v,PersonajeDTO.class))
                .collect(Collectors.toList());
    }
}

package com.personajesstarwars.personajesstarwars.service;

import com.personajesstarwars.personajesstarwars.dto.PersonajeDTO;
import com.personajesstarwars.personajesstarwars.entity.Personaje;
import com.personajesstarwars.personajesstarwars.repository.PersonajeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class PersonajeServiceImp implements PersonajeService{

    //Inyeccion de dependencia
    private final PersonajeRepository personajeRepository;

    public PersonajeServiceImp(PersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }

    @Override
    public List<PersonajeDTO> buscarPorNombre(String nombre) {
        //Recuperamos la lista del repositorio
        return personajeRepository
                .obtenerTodos()
                .stream()
                .filter(p -> p.getName().toLowerCase().contains(nombre.toLowerCase()))
                .map(d -> new PersonajeDTO(d.getName(),
                        d.getGender(),
                        d.getHomeworld(),
                        d.getSpecies(),
                        d.getHeight(),
                        d.getMass()))
                .collect(Collectors.toList());
    }

    //Solamente para mostrar todo
    public List<Personaje> mostrarTodo(){
        return personajeRepository.obtenerTodos();
    }
}

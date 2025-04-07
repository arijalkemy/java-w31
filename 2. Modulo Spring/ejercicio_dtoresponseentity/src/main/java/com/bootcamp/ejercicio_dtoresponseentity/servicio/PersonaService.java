package com.bootcamp.ejercicio_dtoresponseentity.servicio;

import com.bootcamp.ejercicio_dtoresponseentity.dto.PersonaDeporteDto;
import com.bootcamp.ejercicio_dtoresponseentity.modelo.Persona;
import com.bootcamp.ejercicio_dtoresponseentity.repositorio.DeporteRepository;
import com.bootcamp.ejercicio_dtoresponseentity.repositorio.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {
    private final PersonaRepository personaRepository;
    private final DeporteRepository deporteRepository;

    @Autowired
    public PersonaService(PersonaRepository personaRepository, DeporteRepository deporteRepository) {
        this.personaRepository = personaRepository;
        this.deporteRepository = deporteRepository;
        loadData();
    }

    private void loadData(){
        personaRepository.save(new Persona("Juan", "Pérez", 25, deporteRepository.findByName("Baloncesto")));
        personaRepository.save(new Persona("Ana", "Pérez", 26, deporteRepository.findByName("Baloncesto")));
        personaRepository.save(new Persona("Luis", "González", 27, deporteRepository.findByName("Baloncesto")));
        personaRepository.save(new Persona("Carlos", "Fernández", 28, deporteRepository.findByName("Baloncesto")));
        personaRepository.save(new Persona("Sofía", "Martínez", 29, deporteRepository.findByName("Baloncesto")));

        personaRepository.save(new Persona("Miguel", "López", 30, deporteRepository.findByName("Fútbol")));
        personaRepository.save(new Persona("Claudia", "Sánchez", 31, deporteRepository.findByName("Fútbol")));
        personaRepository.save(new Persona("Pedro", "Ramírez", 32, deporteRepository.findByName("Fútbol")));
        personaRepository.save(new Persona("Laura", "Jiménez", 33, deporteRepository.findByName("Fútbol")));
        personaRepository.save(new Persona("Andrés", "Hernández", 34, deporteRepository.findByName("Fútbol")));

        personaRepository.save(new Persona("María", "Díaz", 25, deporteRepository.findByName("Tenis")));
        personaRepository.save(new Persona("José", "González", 26, deporteRepository.findByName("Tenis")));
        personaRepository.save(new Persona("Pablo", "Torres", 27, deporteRepository.findByName("Tenis")));
        personaRepository.save(new Persona("Carmen", "Villanueva", 28, deporteRepository.findByName("Tenis")));
        personaRepository.save(new Persona("David", "Mendoza", 29, deporteRepository.findByName("Tenis")));

        personaRepository.save(new Persona("Elena", "Pérez", 25, deporteRepository.findByName("Natación")));
        personaRepository.save(new Persona("Javier", "Soto", 26, deporteRepository.findByName("Natación")));
        personaRepository.save(new Persona("Laura", "Rosa", 27, deporteRepository.findByName("Natación")));
        personaRepository.save(new Persona("Santiago", "Nava", 28, deporteRepository.findByName("Natación")));
        personaRepository.save(new Persona("Patricia", "Juárez", 29, deporteRepository.findByName("Natación")));

        personaRepository.save(new Persona("Fernando", "Martínez", 25, deporteRepository.findByName("Ciclismo")));
        personaRepository.save(new Persona("Raúl", "Carrillo", 26, deporteRepository.findByName("Ciclismo")));
        personaRepository.save(new Persona("Natalia", "García", 27, deporteRepository.findByName("Ciclismo")));
        personaRepository.save(new Persona("Isabel", "Alvarez", 28, deporteRepository.findByName("Ciclismo")));
        personaRepository.save(new Persona("Oscar", "Salazar", 29, deporteRepository.findByName("Ciclismo")));
    }

    public List<PersonaDeporteDto> getAllWithSport(){
        return personaRepository.findAllWithSport().stream()
                .map(p -> new PersonaDeporteDto(p.getNombre(), p.getApellido(), p.getDeporte().getNombre()))
                .toList();
    }
}

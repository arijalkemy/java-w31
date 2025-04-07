package org.example.ejerciciosdtoresponseentityp2.service;

import org.example.ejerciciosdtoresponseentityp2.model.entity.BdMemoria;
import org.example.ejerciciosdtoresponseentityp2.model.entity.Deporte;
import org.example.ejerciciosdtoresponseentityp2.model.entity.Persona;
import org.example.ejerciciosdtoresponseentityp2.model.entity.PersonaDeporteDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeporteService {

    public BdMemoria cargaDeDatos(){
        Deporte deporte1 = new Deporte("Fútbol", "Profesional");
        Deporte deporte2 = new Deporte("Basketball", "Amateur");
        Deporte deporte3 = new Deporte("Rugby", "Profesional");

        Persona persona1 = new Persona("Juan","Macias",20);
        Persona persona2 = new Persona("Laura","Quintero",15);
        Persona persona3 = new Persona("Carlos","Jinette",30);

        List<Deporte> deportes = new ArrayList<>();
        deportes.add(deporte1);
        deportes.add(deporte2);
        deportes.add(deporte3);

        List<Persona> personas = new ArrayList<>();
        personas.add(persona1);
        personas.add(persona2);
        personas.add(persona3);

        return new BdMemoria(deportes,personas);
    }

    public List<PersonaDeporteDto> cargaDeDatosPersonaDeportesDto(BdMemoria bdMemoria){
        PersonaDeporteDto personaDeporteDto = new PersonaDeporteDto(bdMemoria.getPersonas().get(0).getNombre()+" "+
                bdMemoria.getPersonas().get(0).getApellido(),
                bdMemoria.getDeportes().get(0).getNombre());

        PersonaDeporteDto personaDeporteDto2 = new PersonaDeporteDto(bdMemoria.getPersonas().get(1).getNombre()+" "+
                bdMemoria.getPersonas().get(1).getApellido(),
                bdMemoria.getDeportes().get(1).getNombre());

        PersonaDeporteDto personaDeporteDto3 = new PersonaDeporteDto(bdMemoria.getPersonas().get(2).getNombre()+" "+
                bdMemoria.getPersonas().get(2).getApellido(),
                bdMemoria.getDeportes().get(2).getNombre());

        List<PersonaDeporteDto> personaDeporteDtos = new ArrayList<>();
        personaDeporteDtos.add(personaDeporteDto);
        personaDeporteDtos.add(personaDeporteDto2);
        personaDeporteDtos.add(personaDeporteDto3);

        return personaDeporteDtos;
    }

    public List<PersonaDeporteDto> listarPersonasDeportesDto(List<PersonaDeporteDto> personaDeporteDtos){
        return personaDeporteDtos;
    }

    public List<Deporte> listarDeportes(BdMemoria bdMemoria){
        return bdMemoria.getDeportes();
    }

    public List<String> encontrarDeportePorNombre(BdMemoria bdMemoria, String deporte){
        return bdMemoria.getDeportes().stream().filter(d-> d.getNombre().equals(deporte)).map(deporte1 -> deporte1.getNivel()).toList();
    }

}

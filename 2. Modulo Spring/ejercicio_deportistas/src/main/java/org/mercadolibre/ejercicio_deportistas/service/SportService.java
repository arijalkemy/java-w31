package org.mercadolibre.ejercicio_deportistas.service;

import org.mercadolibre.ejercicio_deportistas.models.Deporte;
import org.mercadolibre.ejercicio_deportistas.models.DeportePersonaDTO;
import org.mercadolibre.ejercicio_deportistas.models.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class SportService {
    List<Deporte> deportesList = new ArrayList<>();
    List<Persona> personasList = new ArrayList<>();

    public SportService() {
        deportesList.add(new Deporte("Fútbol", "Avanzado"));
        deportesList.add(new Deporte("Baloncesto", "Intermedio"));
        deportesList.add(new Deporte("Natación", "Principiante"));
        deportesList.add(new Deporte("Ciclismo", "Avanzado"));
        deportesList.add(new Deporte("Tennis", "Intermedio"));
        deportesList.add(new Deporte("Golf", "Principiante"));
        deportesList.add(new Deporte("Boxeo", "Avanzado"));
        deportesList.add(new Deporte("Yoga", "Principiante"));
        deportesList.add(new Deporte("Karate", "Avanzado"));
        deportesList.add(new Deporte("Voleibol", "Intermedio"));

        personasList.add(new Persona("Juan", "Pérez", 25));
        personasList.add(new Persona("María", "Gómez", 30));
        personasList.add(new Persona("Carlos", "Sánchez", 22));
        personasList.add(new Persona("Ana", "López", 28));
        personasList.add(new Persona("Luis", "Rodríguez", 35));
        personasList.add(new Persona("Laura", "Martínez", 26));
        personasList.add(new Persona("Diego", "Fernández", 27));
        personasList.add(new Persona("Sofía", "Castillo", 20));
        personasList.add(new Persona("Andrés", "Vélez", 32));
        personasList.add(new Persona("Valentina", "Hernández", 24));
    }

    public List<Deporte> findSports(){
        return deportesList;
    }

    public Deporte findSport(String nombre){
        return deportesList.stream().filter(x -> x.getNombre().equals(nombre)).findFirst()
                .orElse(null);
    }

    public List<DeportePersonaDTO> getPersonasYDeportes() {
        List<DeportePersonaDTO> resultado = new ArrayList<>();
        Random random = new Random();

        for (Persona persona : personasList) {
            int randomIndex = random.nextInt(deportesList.size());

            String deporteNombre = deportesList.get(randomIndex).getNombre();

            resultado.add(new DeportePersonaDTO(persona.getName(), persona.getApellido(), deporteNombre));
        }

        return resultado;
    }
}

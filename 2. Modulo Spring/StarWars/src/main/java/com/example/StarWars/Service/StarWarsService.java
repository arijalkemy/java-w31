package com.example.StarWars.Service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import com.example.StarWars.DTO.PersonajeDTO;
import com.example.StarWars.Entities.Personaje;

@Service
public class StarWarsService {
    private List<Personaje> personajes;

    public StarWarsService() {
        this.personajes = List.of(
            new Personaje("Luke Skywalker", 172, 77, "Blonde", "Fair", "Blue", "19BBY", "male", "Tatooine", "Human"),
            new Personaje("Darth Vader", 202, 136, "Black", "White", "Yellow", "41.9BBY", "male", "Tatooine", "Human"),
            new Personaje("Leia Organa", 150, 49, "Brown", "Light", "Brown", "19BBY", "female", "Alderaan", "Human"),
            new Personaje("Han Solo", 180, 80, "Brown", "Fair", "Brown", "29BBY", "male", "Corellia", "Human"),
            new Personaje("Yoda", 66, 17, "White", "Green", "Green", "896BBY", "male", "Dagobah", "Yoda's species"),
            new Personaje("Obi-Wan Kenobi", 182, 77, "Brown", "Fair", "Blue", "57BBY", "male", "Stewjon", "Human"),
            new Personaje("Chewbacca", 228, 112, "Brown", "Brown", "Blue", "200BBY", "male", "Kashyyyk", "Wookiee"),
            new Personaje("R2-D2", 0, 0, "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "Droid"),
            new Personaje("C-3PO", 0, 0, "N/A", "N/A", "N/A", "N/A", "N/A", "N/A", "Droid"),
            new Personaje("Palpatine", 170, 75, "White", "Pale", "Yellow", "82BBY", "male", "Naboo", "Human")
        );
    }
    

    public List<PersonajeDTO> findCharacterByName(String name) {
        List<PersonajeDTO> personajesDTO = new ArrayList<PersonajeDTO>();
        personajes.stream()
                  .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                  .forEach(p -> personajesDTO.add(PersonajeDTO.convertToDTO(p)));
        return personajesDTO;
    }
}
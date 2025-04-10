package com.example.ejercicioDeportistas.service;

import com.example.ejercicioDeportistas.dto.SportPersonDTO;
import com.example.ejercicioDeportistas.model.Person;
import com.example.ejercicioDeportistas.model.Sport;
import com.example.ejercicioDeportistas.repository.SportRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SportService {
    private final SportRepository repo = new SportRepository();

    public Sport findByName(String name) {
        List<Sport> sports = repo.getSports();
        for (Sport sport : sports) {
            if (sport.getName().equals(name))
                return sport;
        }
        return null;
    }

    public List<Sport> getAllSports(){
        return repo.getSports();
    }

    public HashMap<String, List<Person>> getSportPersonsBySport() {
        return repo.getSportPersons();
    }

    public List<SportPersonDTO> getSportsPersons(){
        List<SportPersonDTO> sportPersonsList = new ArrayList<>();
        HashMap<String, List<Person>> sportPersonsBySport = getSportPersonsBySport();

        for (Map.Entry<String, List<Person>> entry : sportPersonsBySport.entrySet()) {
            String sportName = entry.getKey();
            List<Person> persons = entry.getValue();
            for (Person person : persons) {
                SportPersonDTO sportPersonDTO = new SportPersonDTO(person.getName(), person.getLastname(), sportName);
                sportPersonsList.add(sportPersonDTO);
            }

        }
        return sportPersonsList;
    }
}

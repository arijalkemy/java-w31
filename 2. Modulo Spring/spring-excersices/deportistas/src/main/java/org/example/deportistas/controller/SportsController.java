package org.example.deportistas.controller;

import org.example.deportistas.dto.SportPersonDTO;
import org.example.deportistas.entities.Person;
import org.example.deportistas.entities.Sport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class SportsController {
    private List<Sport> sports = new ArrayList<>();
    private List<Person> person = new ArrayList<>();

    public SportsController() {
        sports.add(new Sport("Fútbol", "Avanzado"));
        sports.add(new Sport("Baloncesto", "Intermedio"));

        person.add(new Person("Juan", "Perez", 30, sports.get(0)));
        person.add(new Person("Maria", "Garcia", 25, sports.get(1)));
    }

    @GetMapping("/findSports")
    public List<Sport> getAllDeportes() {
        return sports;
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity getDeporteByName(@PathVariable String name) {
        for (Sport sport : sports) {
            if (sport.getName().equalsIgnoreCase(name)) {
                return new ResponseEntity<>(sport.getLevel(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findSportsPersons")
    public List<SportPersonDTO> getDeportistas() {
        List<SportPersonDTO> deportistasDTO = new ArrayList<>();
        for (Person person : person) {
            SportPersonDTO dto = new SportPersonDTO(
                    person.getName(),
                    person.getLastName(),
                    person.getSport().getName()
            );
            deportistasDTO.add(dto);
        }
        return deportistasDTO;
    }


    }

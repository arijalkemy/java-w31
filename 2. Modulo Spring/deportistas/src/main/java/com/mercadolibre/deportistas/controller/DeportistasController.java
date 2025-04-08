package com.mercadolibre.deportistas.controller;

import com.mercadolibre.deportistas.model.Sport;
import com.mercadolibre.deportistas.model.Person;
import com.mercadolibre.deportistas.dto.PersonDTO;
import com.mercadolibre.deportistas.repository.DeportistasRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeportistasController {

    DeportistasRepository deportistasRepository = new DeportistasRepository();

    @GetMapping(path = "/find-sports")
    public ResponseEntity<List<Sport>> findSports() {
        try {
            return new ResponseEntity<>(deportistasRepository.getDeportes(), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping (path = "/find-sport/{name}")
    public ResponseEntity<String> findSportByName(@PathVariable String name) {
        try {
            return new ResponseEntity<>(deportistasRepository.buscar(name), HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Algo salió mal", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/find-sports-persons")
    public ResponseEntity<List<PersonDTO>> findSportsPersons() {
        try {
            ArrayList <PersonDTO> sportsPersons = new ArrayList<>();
            for (Person person : deportistasRepository.getPersonas()) {
                sportsPersons.add(new PersonDTO(
                        person.getNombre() + " " + person.getApellido(),
                        person.deportesToString()
                ));
            }
            return new ResponseEntity<>(sportsPersons, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

package com.bootcamp.ej_deportistas.controller;

import com.bootcamp.ej_deportistas.dto.PersonDTO;
import com.bootcamp.ej_deportistas.model.Person;
import com.bootcamp.ej_deportistas.model.Sport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class SportsController {
    //simulando una base de datos
    private List<Sport> sports;
    private List<Person> persons;

    public SportsController() {
        sports = new ArrayList<>();
        persons = new ArrayList<>();

        sports.add(new Sport("Futbol","4"));
        sports.add(new Sport("Running","2"));
        sports.add(new Sport("Hockey","3"));

        persons.add(new Person("Manuela", "Tonelli",25,List.of(sports.get(0),sports.get(1))));
        persons.add(new Person("Trinidad", "Tonelli",25,List.of(sports.get(2),sports.get(1))));

    }

    // Ver todos los deportes que tenemos cargados.
    @GetMapping("/findSports")
    public ResponseEntity<List<Sport>> findSports() {
        return ResponseEntity.ok(sports);
    }

    //Consultar si existe un deporte ingresando su nombre.
    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findSportyName(@PathVariable("name") String name) {
        Optional<Sport> sportOptional = sports.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst();

        if (sportOptional.isPresent()) {
            return ResponseEntity.ok("Nivel: " + sportOptional.get().getLevel());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Deporte no encontrado.");
        }
    }

    //ver a las personas y el deporte que realizan
    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<PersonDTO>> findSportsPersons() {
        List<PersonDTO> sportsPersons = new ArrayList<>();

        for (Person person : persons) {
            if (person.getSports() != null && !person.getSports().isEmpty()) {
                // Crear una lista de nombres de deportes
                List<String> sportsNames = person.getSports()
                        .stream()
                        .map(Sport::getName)
                        .collect(Collectors.toList());
                sportsPersons.add(new PersonDTO(person.getName(), person.getSurname(), sportsNames));
            }
        }
        return ResponseEntity.ok(sportsPersons);
    }

}

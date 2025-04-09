package com.mercadolibre.modulospring.deportistas.controller;

import com.mercadolibre.modulospring.deportistas.dto.SportPersonDTO;
import com.mercadolibre.modulospring.deportistas.model.Person;
import com.mercadolibre.modulospring.deportistas.model.Sport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class DeportistaController {

    @GetMapping("/findSports")
    public List<Sport> getSports() {

        return this.fillSports();

    }
    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> getSport(@PathVariable String name) {
        try {
            List<Sport> sports = this.fillSports();
            String uniquesport = sports.stream().filter(sport -> sport.getName().equals(name)).map(Sport::getLevel).findFirst().get();
            return new ResponseEntity<String>(uniquesport, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }


    }
    @GetMapping("/findSportsPersons")
    public ResponseEntity<List<SportPersonDTO>> getSportPersons() {
        this.fillSports();
        List<Sport> sports = this.fillSports();
        List<Person>people=this.fillPeople();
        List<SportPersonDTO> dtos=new ArrayList<SportPersonDTO>();
        String sport=sports.get(0).getName();
        dtos.add(new SportPersonDTO(people.get(0).getSports().stream().map(Sport::getName).toList(),people.get(0).getName(),people.get(0).getLastname()));
        dtos.add(new SportPersonDTO(people.get(1).getSports().stream().map(Sport::getName).toList(),people.get(1).getName(),people.get(1).getLastname()));
        return new ResponseEntity<>(dtos, HttpStatus.OK);



    }

    public List<Sport> fillSports(){
        List<Sport> sports = new ArrayList<>();
        sports.add(new Sport("Basquetball","Avanzado"));
        sports.add(new Sport("Baseball","Principiante"));
        sports.add(new Sport("Rugby","Intermedio"));
        return sports;
    }
    public List<Person> fillPeople(){
        List<Person> people = new ArrayList<>();
        List<Sport> sports = this.fillSports();
        people.add(new Person("Diego","Rodrigo",23,sports));
        people.add(new Person("Santiago","Mendez",13,sports));
        return people;

    }




}

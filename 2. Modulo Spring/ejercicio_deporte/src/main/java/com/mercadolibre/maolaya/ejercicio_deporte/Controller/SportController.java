package com.mercadolibre.maolaya.ejercicio_deporte.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.maolaya.ejercicio_deporte.Model.Dto.SportDto;
import com.mercadolibre.maolaya.ejercicio_deporte.Model.Dto.SportPersonDto;
import com.mercadolibre.maolaya.ejercicio_deporte.Service.PersonService;
import com.mercadolibre.maolaya.ejercicio_deporte.Service.SportService;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class SportController {
    @GetMapping("/findSports")
    public List<SportDto> getAllSports() {
        return SportService.getAllSports();
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> getSport(@PathVariable String name) {
        try {
            return new ResponseEntity<>(SportService.getSport(name), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Sport not found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findSportsPersons")
    public List<SportPersonDto> getSportsPersons() {
        return PersonService.getAllPersons();
    }

}

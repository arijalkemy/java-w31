package com.example.ejercicioDeportistas.controller;

import com.example.ejercicioDeportistas.dto.SportPersonDTO;
import com.example.ejercicioDeportistas.repository.SportRepository;
import com.example.ejercicioDeportistas.model.Person;
import com.example.ejercicioDeportistas.model.Sport;
import com.example.ejercicioDeportistas.service.SportService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SportPersonController {
    private final SportService sportService = new SportService();


    @GetMapping(path = "/findSports")
    @ResponseBody
    public List<Sport> getSports(){
        return sportService.getAllSports();
    }

    @GetMapping("/findSports/{name}")
    ResponseEntity<Sport> findSportByName (@PathVariable String name) {
        return new ResponseEntity<>(sportService.findByName(name), HttpStatus.OK);
    }

    @GetMapping(path = "/findSportsPersons")
    @ResponseBody
    public List<SportPersonDTO> getSportsPersons(){
        return sportService.getSportsPersons();
    }


}

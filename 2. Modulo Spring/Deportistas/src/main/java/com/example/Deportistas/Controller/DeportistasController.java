package com.example.Deportistas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.Deportistas.Entities.DeportistaDTO;
import com.example.Deportistas.Entities.Deporte;
import com.example.Deportistas.Service.DeportistasService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
@RequestMapping("/")
public class DeportistasController {
    @Autowired
    private DeportistasService deportistasService;

    @GetMapping("/findSports")
    @ResponseBody
    public List<Deporte> findSports() {
        return deportistasService.getAllSports();
    }

    @GetMapping("/findSports/{name}")
    @ResponseBody
    public ResponseEntity<String> findSportByName(@PathVariable String name) {
        Deporte deporte = deportistasService.findSportByName(name);
        if (deporte != null) {
            return new ResponseEntity<>(deporte.getNivel(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Deporte no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findSportsPersons")
    @ResponseBody
    public List<DeportistaDTO> findSportsPersons() {
        return deportistasService.getAllPersonsWithSports();
    }
}

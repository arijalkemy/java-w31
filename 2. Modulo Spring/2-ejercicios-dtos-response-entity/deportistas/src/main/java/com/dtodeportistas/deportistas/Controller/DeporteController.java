package com.dtodeportistas.deportistas.Controller;

import com.dtodeportistas.deportistas.DTO.DeporteDTO;
import com.dtodeportistas.deportistas.Service.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeporteController {

    @Autowired
    private DeporteService deporteService;

    @GetMapping("/findSports")
    public List<DeporteDTO> getDeportes() {
        return deporteService.getTodosLosDeportes();
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<String> findSportByName(@PathVariable String name) {
        try {
            Integer nivel = deporteService.getNivelByDeporte(name);
            return new ResponseEntity<>("El deporte " + name + " es de nivel " + nivel, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("El deporte " + name + " no existe", HttpStatus.NOT_FOUND);
        }
    }

}




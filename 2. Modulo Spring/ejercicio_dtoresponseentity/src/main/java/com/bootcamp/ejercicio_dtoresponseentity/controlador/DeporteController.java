package com.bootcamp.ejercicio_dtoresponseentity.controlador;

import com.bootcamp.ejercicio_dtoresponseentity.dto.DeporteDto;
import com.bootcamp.ejercicio_dtoresponseentity.servicio.DeporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deportes")
public class DeporteController {
    private final DeporteService deporteService;

    @Autowired
    public DeporteController(DeporteService deporteService) {
        this.deporteService = deporteService;
    }

    @ResponseBody
    @GetMapping("/findSports")
    public ResponseEntity<List<DeporteDto>> getAll(){
        return new ResponseEntity<>(deporteService.findAll(), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping("/findSports/{name}")
    public ResponseEntity<DeporteDto> getSportByName(@PathVariable String name){
        DeporteDto deporteDto = deporteService.findByName(name);
        if(deporteDto == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(deporteDto, HttpStatus.OK);
    }
}

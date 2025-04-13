package org.example.manejoexcepcionesp1.controller;

import org.example.manejoexcepcionesp1.dto.EntradaBlogDto;
import org.example.manejoexcepcionesp1.service.EntradaBlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class EntradaBlogController {

    @Autowired
    EntradaBlogServiceImpl entradaBlogService;

    @PostMapping("/blog")
    public ResponseEntity<String> crearEntradaBlog(@RequestBody EntradaBlogDto entradaBlogDto){
        return new ResponseEntity<>(entradaBlogService.crearEntradaBlog(entradaBlogDto),
                HttpStatus.OK);
    }
    @GetMapping("blog/{id}")
    public ResponseEntity<EntradaBlogDto> buscarEntradaBlogPorId(@PathVariable int id){
        return new ResponseEntity<>(entradaBlogService.buscarEntradaBlogPorId(id),
                HttpStatus.OK);
    }

    @GetMapping("blogs")
    public ResponseEntity<List<EntradaBlogDto>> listarEntradaBlog(){
        return new ResponseEntity<>(entradaBlogService.listarEntradaBlog(),
                HttpStatus.OK);
    }
}

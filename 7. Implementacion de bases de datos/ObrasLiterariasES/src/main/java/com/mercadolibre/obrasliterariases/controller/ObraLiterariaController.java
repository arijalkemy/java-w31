package com.mercadolibre.obrasliterariases.controller;

import com.mercadolibre.obrasliterariases.model.ObraLiteraria;
import com.mercadolibre.obrasliterariases.service.ObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras")
public class ObraLiterariaController {

    @Autowired
    private ObraLiterariaService service;

    //crear una obra
    @PostMapping
    public ResponseEntity<ObraLiteraria> crearObra(@RequestBody ObraLiteraria obra) {
        return new ResponseEntity<>(service.crearObra(obra), HttpStatus.CREATED);
    }

    //Buscar obras por autor
    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<ObraLiteraria>> obrasPorAutor(@PathVariable String autor) {
        return new ResponseEntity<>(service.obrasPorAutor(autor), HttpStatus.OK);
    }


    //Obras que contengan palabras clave en sus titulos
    @GetMapping("/titulo")
    public ResponseEntity<List<ObraLiteraria>> obrasPorPalabraClave(@RequestParam String palabra) {
        return new ResponseEntity<>(service.obrasPorPalabraClave(palabra), HttpStatus.OK);
    }

//    Retornar el top 5 de las obras literarias con más cantidad de páginas. Ordenar el resultado de mayor a menor.
    @GetMapping("/top5")
    public ResponseEntity<List<ObraLiteraria>> top5PorPaginas() {
        return new ResponseEntity<>(service.top5PorPaginas(), HttpStatus.OK);
    }


//    Retornar las obras que fueron publicadas antes de un determinado año.
//    Por ejemplo: Antes de 1998.
    @GetMapping("/antes-de/{anio}")
    public ResponseEntity<List<ObraLiteraria>> obrasAntesDe(@PathVariable int anio) {
        return new ResponseEntity<>(service.obrasAntesDe(anio), HttpStatus.OK);
    }

//    Retornar todas las obras de una determinada editorial. Por ejemplo:
//    Todas las obras de la editorial “Santillana”
    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<List<ObraLiteraria>> obrasPorEditorial(@PathVariable String editorial) {
        return new ResponseEntity<>(service.obrasPorEditorial(editorial), HttpStatus.OK);
    }
}
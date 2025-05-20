package com.mercadolibre.elasticsearch2.controller;

import com.mercadolibre.elasticsearch2.dto.ObraLiterariaDto;
import com.mercadolibre.elasticsearch2.model.ObraLiteraria;
import com.mercadolibre.elasticsearch2.service.IObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/obras-literarias")
public class ObraLiterariaController {

    @Autowired
    IObraLiterariaService obraLiterariaService;

    @PostMapping("/new")
    public ResponseEntity<ObraLiterariaDto> save(@RequestBody ObraLiterariaDto obraLiteraria) {
        return new ResponseEntity<>(obraLiterariaService.save(obraLiteraria), HttpStatus.CREATED);
    }

    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<ObraLiterariaDto>> getByAutor(@PathVariable String autor) {
        return new ResponseEntity<>(obraLiterariaService.getByAutor(autor), HttpStatus.OK);
    }

    @GetMapping("/editorial/{editorial}")
    public ResponseEntity<List<ObraLiterariaDto>> getByEditorial(@PathVariable String editorial) {
        return new ResponseEntity<>(obraLiterariaService.getByEditorial(editorial), HttpStatus.OK);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<ObraLiterariaDto>> getByNombre(@PathVariable String nombre) {
        return new ResponseEntity<>(obraLiterariaService.getByNombre(nombre), HttpStatus.OK);
    }

    @GetMapping("/top-5-mas-paginas")
    public ResponseEntity<List<ObraLiterariaDto>> getTop5MasPaginas() {
        return new ResponseEntity<>(obraLiterariaService.getTop5MasPaginas(), HttpStatus.OK);
    }

    @GetMapping("/publicadas-antes-de/{anio}")
    public ResponseEntity<List<ObraLiterariaDto>> getPublicadasAntesDelAnio(@PathVariable Integer anio) {
        return new ResponseEntity<>(obraLiterariaService.getPublicadasAntesDelAnio(anio), HttpStatus.OK);
    }
}

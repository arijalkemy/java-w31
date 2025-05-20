package org.example.ejerciciopracticosextra1.controller;

import org.example.ejerciciopracticosextra1.model.Prenda;
import org.example.ejerciciopracticosextra1.service.PrendaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class PrendaController {

    private final PrendaServiceImpl prendaService;

    @Autowired
    public PrendaController(PrendaServiceImpl prendaService) {
        this.prendaService = prendaService;
    }

    @GetMapping()
    public ResponseEntity<List<Prenda>> getAllPrendas(){
        return new ResponseEntity<>(this.prendaService.getAllPrendas(), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Prenda> getPrendaByCodigo(@PathVariable String code){
        return new ResponseEntity<>(this.prendaService.getPrendaByCodigo(code), HttpStatus.OK);
    }

    @GetMapping("/{size}")
    public ResponseEntity<List<Prenda>> getPrendaByTalla(@PathVariable(name = "size") Prenda.Talla talla){
        return new ResponseEntity<>(this.prendaService.getPrendaByTalla(talla), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Prenda>> getPrendaByNombre(@PathVariable(name = "name") String nombre){
        return new ResponseEntity<>(this.prendaService.getPrendaByNombre(nombre), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Void> createPrenda(@RequestBody Prenda prenda){
        this.prendaService.createPrenda(prenda);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<Void> updatePrenda(@PathVariable(name = "code") String codigo, @RequestBody Prenda prenda){
        this.prendaService.updatePrenda(codigo,prenda);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deletePrenda(@PathVariable(name = "code") String codigo){
        this.prendaService.deletePrenda(codigo);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

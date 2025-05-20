package org.example.ejerciciopracticosextra1.controller;

import org.example.ejerciciopracticosextra1.model.Prenda;
import org.example.ejerciciopracticosextra1.model.Venta;
import org.example.ejerciciopracticosextra1.service.PrendaServiceImpl;
import org.example.ejerciciopracticosextra1.service.VentaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class VentaController {

    private final VentaServiceImpl ventaService;

    @Autowired
    public VentaController(VentaServiceImpl ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping()
    public ResponseEntity<List<Venta>> getVentas(){
        return new ResponseEntity<>(this.ventaService.getVentas(),HttpStatus.OK) ;
    }

    @GetMapping("/{number}")
    public ResponseEntity<Venta> getVentaByNumero(@PathVariable(name = "number") Long numero){
        return new ResponseEntity<>(this.ventaService.getVentaByNumero(numero),HttpStatus.OK) ;
    }

    @GetMapping("/")
    public ResponseEntity<List<Prenda>> getPrendasByFecha(@RequestParam(name = "date") Date fecha){
        return new ResponseEntity<>(this.ventaService.getPrendasByFecha(fecha),HttpStatus.OK);
    }

    @GetMapping("/clothes/{number}")
    public ResponseEntity<List<Prenda>> getPrendasByNumero(@PathVariable(name = "number") Long numeroVenta){
        return new ResponseEntity<>(this.ventaService.getPrendasByNumero(numeroVenta), HttpStatus.OK) ;
    }

    @PostMapping()
    public ResponseEntity<Void> createVenta(@RequestBody Venta venta){
        this.ventaService.createVenta(venta);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{number}")
    public ResponseEntity<Void> updateVenta(@PathVariable(name = "number") Long numero, @RequestBody Venta venta){
        this.ventaService.updateVenta(numero,venta);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{number}")
    public ResponseEntity<Void> deletePrenda(@PathVariable(name = "number") Long numero){
        this.ventaService.deleteVenta(numero);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

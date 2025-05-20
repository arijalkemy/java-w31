package com.meli.maolaya.siniestro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.meli.maolaya.siniestro.dto.VehiculoDto;
import com.meli.maolaya.siniestro.dto.VehiculoSiniestroDto;
import com.meli.maolaya.siniestro.service.IVehiculoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    private IVehiculoService vehiculoService;

    @GetMapping("/patente")
    public ResponseEntity<List<VehiculoDto>> getPatentes() {
        return ResponseEntity.ok(vehiculoService.findPatentes());
    }

    @PostMapping("/new")
    public ResponseEntity<Void> postNewVehiculo(@RequestBody VehiculoDto vehiculoDto) {
        vehiculoService.saveVehiculo(vehiculoDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/patente/marca")
    public ResponseEntity<List<VehiculoDto>> getPatenteAndMarcaOrderByAño() {
        return ResponseEntity.ok(vehiculoService.findPatentesMarcasOrderByYear());
    }

    @GetMapping("/patente/currentyear")
    public ResponseEntity<List<VehiculoDto>> getPatenteByRuedasAndAño() {
        return ResponseEntity.ok(vehiculoService.findPatentesByRuedasAndYear());
    }

    @GetMapping("/patente/marca/modelo")
    public ResponseEntity<List<VehiculoDto>> getPerdidaGreaterThan10000() {
        return ResponseEntity.ok(vehiculoService.findGreaterThan10000());
    }

    @GetMapping("/patente/marca/modelo/sum")
    public ResponseEntity<List<VehiculoSiniestroDto>> getPerdidaGreaterThan10000sum() {
        return ResponseEntity.ok(vehiculoService.findGreaterThan10000sum());
    }

}

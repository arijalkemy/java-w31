package com.example.jpa.controller;

import com.example.jpa.dto.VehiculoSiniestroDto;
import com.example.jpa.projection.VehiclePlacaMarcaModeloProjection;
import com.example.jpa.projection.VehiclePlacaMarcaProjection;
import com.example.jpa.service.VehicleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VehicleController {
    private final VehicleServiceImpl vehicleService;
    
    @Autowired
    public VehicleController(VehicleServiceImpl vehicleService) {
        this.vehicleService = vehicleService;
    }
    
    @GetMapping("/getPlacas")
    public ResponseEntity<?> getPlacas() {
        List<String> allPlacas = vehicleService.findAllPlacas();
        return new ResponseEntity<>(allPlacas, HttpStatus.OK);
    }

    @GetMapping("/getPlacaAndMarca")
    public ResponseEntity<?> getPlacaAndMarca() {
        List<VehiclePlacaMarcaProjection> allPlacas = vehicleService.findPlacaAndMarca();
        return new ResponseEntity<>(allPlacas, HttpStatus.OK);
    }

    @GetMapping("/getPlacasByNumberWheels")
    public ResponseEntity<?> getPlacasByNumberWheels() {
        List<String> allPlacas = vehicleService.findAllPlacasByNumberOfWheels();
        return new ResponseEntity<>(allPlacas, HttpStatus.OK);
    }

    @GetMapping("/getPlacasAndMarcaAndModelo")
    public ResponseEntity<?> getPlacasAndMarcaAndModelo() {
        List<VehiclePlacaMarcaModeloProjection> allPlacas = vehicleService.findPlacaAndMarcaAndModelo();
        return new ResponseEntity<>(allPlacas, HttpStatus.OK);
    }

    @GetMapping("/getTotalPlacas")
    public ResponseEntity<?> getTotalPlacas() {
        List<VehiculoSiniestroDto> allPlacas = vehicleService.obtenerVehiculosConPerdidaMayorA();
        return new ResponseEntity<>(allPlacas, HttpStatus.OK);
    }
}

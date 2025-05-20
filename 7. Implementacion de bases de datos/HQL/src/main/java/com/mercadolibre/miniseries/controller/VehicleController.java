package com.mercadolibre.miniseries.controller;

import com.mercadolibre.miniseries.dto.VehicleDto;
import com.mercadolibre.miniseries.model.Vehicle;
import com.mercadolibre.miniseries.service.IVehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
    private IVehicleService vehicleService;

    public VehicleController(IVehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/matricula")
    public ResponseEntity<List<String>> getAll(){
        return new ResponseEntity<>(vehicleService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/order")
    public ResponseEntity<List<VehicleDto>> getAllOrder(){
        return new ResponseEntity<>(vehicleService.getAllOrder(), HttpStatus.OK);
    }

    @GetMapping("/year")
    public ResponseEntity<List<VehicleDto>> getByYear(){
        return new ResponseEntity<>(vehicleService.getByYear(), HttpStatus.OK);
    }

    @GetMapping("/siniestro")
    public ResponseEntity<List<VehicleDto>> getSinister(){
        return new ResponseEntity<>(vehicleService.getSinister(), HttpStatus.OK);
    }

}

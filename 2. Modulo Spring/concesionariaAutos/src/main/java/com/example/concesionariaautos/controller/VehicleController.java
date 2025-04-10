package com.example.concesionariaautos.controller;


import com.example.concesionariaautos.dto.VehicleDto;
import com.example.concesionariaautos.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;

@RestController
public class VehicleController {
    @Autowired
    IVehicleService vehicleService;

    @PostMapping("v1/api/vehicles/")
    public ResponseEntity<?> postVehicle(@RequestBody VehicleDto vehicle)  {
        try {
            return ResponseEntity.ok(vehicleService.addVehicle(vehicle));
        }catch (InstanceAlreadyExistsException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("v1/api/vehicles/")
    public ResponseEntity<?> getVehicles(){
        return ResponseEntity.ok(vehicleService.searchAllVehicles());
    }

    @GetMapping("v1/api/vehicles/dates")
    public ResponseEntity<?> getVehiclesByYear(@RequestParam String since, @RequestParam String to){
        return ResponseEntity.ok(vehicleService.searchVehiclesByYear(since, to));
    }

    @GetMapping("v1/api/vehicles/prices")
    public ResponseEntity<?> getVehiclesByPrice(@RequestParam String since, @RequestParam String to){
        return ResponseEntity.ok(vehicleService.searchVehiclesByPrice(since, to));
    }

    @GetMapping("v1/api/vehicles/{id}")
    public ResponseEntity<?> getVehicleById(@PathVariable String id){
        try {
            return ResponseEntity.ok(vehicleService.searchVehicleById(id));
        }catch (InstanceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}

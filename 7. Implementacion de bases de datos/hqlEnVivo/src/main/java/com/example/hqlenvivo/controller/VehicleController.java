package com.example.hqlenvivo.controller;

import com.example.hqlenvivo.model.CreateVehicleRequest;
import com.example.hqlenvivo.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicle")
@AllArgsConstructor
public class VehicleController {

    private VehicleService vehicleService;

    @PostMapping
    public ResponseEntity<?> createVehicle(@RequestBody CreateVehicleRequest newVehicle) {
        return new ResponseEntity<>(vehicleService.createVehicle(newVehicle), HttpStatus.CREATED);
    }

}

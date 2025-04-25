package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    IVehicleService service;

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVechiles(){
        return new ResponseEntity<>(service.searchAllVehicles(), HttpStatus.OK);
    }

    @PostMapping("/vehicles")
    public ResponseEntity<?> addVehicle(@RequestBody VehicleDto vehicleDto){
        service.addVehicle(vehicleDto);
        return new ResponseEntity<>("SE CREO EXISTOSAMENTE",HttpStatus.CREATED);

        //Mensaje de exito
    }
}

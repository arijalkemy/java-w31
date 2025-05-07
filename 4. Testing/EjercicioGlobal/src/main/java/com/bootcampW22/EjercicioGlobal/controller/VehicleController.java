package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping("/vehicles")
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @PostMapping("/vehicles")
    public ResponseEntity<?> addVehicle(@RequestBody VehicleDto vehicleDto){
        return new ResponseEntity<>(vehicleService.addNewCar(vehicleDto), HttpStatus.OK);
    }

    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<?> findByColorYear(@PathVariable String color, @PathVariable int year){
        return new ResponseEntity<>(vehicleService.findByColorYear(color, year), HttpStatus.OK);
    }

    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> findByBrandYear(@PathVariable String brand,
                                             @PathVariable int start_year,
                                             @PathVariable int end_year){
        return new ResponseEntity<>(vehicleService.findByBrandYear(brand, start_year, end_year), HttpStatus.OK);
    }

    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> averageSpeed(@PathVariable String brand){
        return new ResponseEntity<>(vehicleService.averageSpeed(brand), HttpStatus.OK);
    }

    @PostMapping("/vehicles/batch")
    public ResponseEntity<?> addAllVehicles(@RequestBody List<VehicleDto> vehicleList){
        return ResponseEntity.ok(vehicleService.addAllVehicles(vehicleList));
    }

    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?> editSpeed(@PathVariable Long id){
        vehicleService.editSpeed(id);
        return ResponseEntity.ok("Velocidad del vehículo actualizada exitosamente.");
    }

    @GetMapping("/vehicles/fuel_type/{type}")
    public ResponseEntity<?> fuelList(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.fuelTypeList(type), HttpStatus.OK);
    }

    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable Long id){
        vehicleService.deleteVehicle(id);
        return new ResponseEntity<>("Vehículo eliminado exitosamente.", HttpStatus.OK);
    }

    @GetMapping("/vehicles/transmission/{type}")
    public ResponseEntity<?> findByTransmission(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.findByTransmission(type), HttpStatus.OK);
    }

    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<?> findByDimensions(@RequestParam String length, @RequestParam String width){
        return new ResponseEntity<>(vehicleService.findByDimension(length, width), HttpStatus.OK);
    }


}

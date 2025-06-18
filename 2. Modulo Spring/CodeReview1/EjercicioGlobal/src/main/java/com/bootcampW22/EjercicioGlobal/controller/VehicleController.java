package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<?> getVehiclesByColorAndYear(@PathVariable String color, @PathVariable int year){
        return new ResponseEntity<>(vehicleService.searchByColorAndYear(color, year), HttpStatus.OK);
    }

    @GetMapping("/vehicles/brand/{brand}/between/{startYear}/{endYear}")
    public ResponseEntity<?> getVehiclesByBrandAndYear(@PathVariable String brand, @PathVariable int startYear,
                                                       @PathVariable int endYear){
        return ResponseEntity.ok(vehicleService.searchByBrandAndYear(brand, startYear, endYear));
    }

    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> getAverageSpeedbyBrand(@PathVariable String brand){
        return ResponseEntity.ok(vehicleService.searchAverageSpeedByBrand(brand));
    }

    @GetMapping("/vehicles/fuel_type/{type}")
    ResponseEntity<?> getVehiclesByFuel(@PathVariable String type){
        return ResponseEntity.ok(vehicleService.searchByFuelType(type));
    }

    @GetMapping("/vehicles/transmission/{type}")
    ResponseEntity<?> getVehiclesByTransmission(@PathVariable String type){
        return ResponseEntity.ok(vehicleService.searchByTransmission(type));
    }
    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<?> getAveragePeopleByBrand(@PathVariable String brand){
        return ResponseEntity.ok(vehicleService.searchAveragePeopleByBrand(brand));
    }

    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<?> getVehiclesByDimensions(@RequestParam String height, @RequestParam String width){
        return ResponseEntity.ok(vehicleService.searchByDimensions(height, width));
    }

    @GetMapping("/vehicles/weight")
    public ResponseEntity<?> getVehiclesByWeight(@RequestParam double weightMin, @RequestParam double weightMax){
        return ResponseEntity.ok(vehicleService.searchByWeight(weightMin, weightMax));
    }

    @PostMapping("/vehicles/batch")
    public ResponseEntity<?> postVehicles(@RequestBody List<VehicleDto> vehicles){
        return ResponseEntity.ok(vehicleService.addVehicles(vehicles));
    }

    @PostMapping("/vehicles")
    public ResponseEntity<?> postVehicle(@RequestBody VehicleDto vehicleDto){
        return new ResponseEntity<>(vehicleService.addNewVehicle(vehicleDto), HttpStatus.CREATED);
    }

    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?> putUpdateSpeed(@PathVariable Long id, @RequestBody String speed){
        return ResponseEntity.ok(vehicleService.updateSpeed(id, speed));
    }

    @PutMapping("/vehicles/{id}/update_fuel")
    public ResponseEntity<?> putUpdateFuel(@PathVariable Long id, @RequestBody String fuelType){
        return ResponseEntity.ok(vehicleService.updateFuel(id, fuelType));
    }

    @DeleteMapping("/vehicles/{id}")
    ResponseEntity<?> deleteVehicle(@PathVariable Long id){
        return new ResponseEntity<>(vehicleService.deleteVehicleById(id), HttpStatus.NO_CONTENT);
    }




}

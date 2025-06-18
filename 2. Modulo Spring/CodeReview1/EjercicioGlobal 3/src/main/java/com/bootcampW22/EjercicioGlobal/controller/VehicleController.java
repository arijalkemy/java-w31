package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.RequestFuelTypeDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.service.IVehicleService;
import com.bootcampW22.EjercicioGlobal.service.VehicleServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    IVehicleService vehicleService;

    public VehicleController(VehicleServiceImpl vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<?> getVehicles(){
        return new ResponseEntity<>(vehicleService.searchAllVehicles(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteVehicle(@PathVariable Long id){
        return new ResponseEntity<>(vehicleService.deleteVehicleById(id), HttpStatus.NO_CONTENT);
    }

    @PostMapping("/batch")
    ResponseEntity<?> postVehicles(@RequestBody List<VehicleDto> vehicles){
        return new ResponseEntity<>(vehicleService.addListOfVehicles(vehicles), HttpStatus.CREATED);
    }

    @GetMapping("/dimensions")
    ResponseEntity<?> getVehiclesByDimensions(@RequestParam String height, @RequestParam String width){
        return ResponseEntity.ok(vehicleService.searchVehiclesByDimensions(height, width));
    }

    @GetMapping("/average_capacity/brand/{brand}")
    ResponseEntity<?> getAverageCapacityByBrand(@PathVariable String brand){
        return ResponseEntity.ok(vehicleService.searchAverageCapacityByBrand(brand));
    }

    @PutMapping("/{id}/update_fuel")
    ResponseEntity<?> putFuelType(@PathVariable Long id, @RequestBody RequestFuelTypeDto fuelType){
        return ResponseEntity.ok(vehicleService.updateFuelType(id, fuelType));
    }

    @GetMapping("/transmission/{type}")
    ResponseEntity<?> getVehiclesByTransmission(@PathVariable String type){
        return ResponseEntity.ok(vehicleService.searchVehiclesByTransmission(type));
    }

    @GetMapping("/weight")
    ResponseEntity<?> getVehiclesByWeight(@RequestParam double minWeight, @RequestParam double maxWeight){
        return ResponseEntity.ok(vehicleService.searchVehiclesByWeight(minWeight, maxWeight));
    }

    @GetMapping("/brand/{brand}/between/{startYear}/{endYear}")
    ResponseEntity<?> getVehiclesByBrandAndYear(@PathVariable String brand, @PathVariable int startYear, @PathVariable int endYear){
        return ResponseEntity.ok(vehicleService.searchVehiclesByBrandAndYear(brand, startYear, endYear));
    }

}

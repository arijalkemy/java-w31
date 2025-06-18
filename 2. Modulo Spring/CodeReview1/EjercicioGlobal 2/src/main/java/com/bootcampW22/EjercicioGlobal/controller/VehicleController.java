package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.ResquestSpeedDto;
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

    @PostMapping("/batch")
    public ResponseEntity<?> postListOfVehicles(@RequestBody List<VehicleDto> vehicles){
        return new ResponseEntity<>(vehicleService.addVehicles(vehicles), HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<?> postVehicle(@RequestBody VehicleDto vehicleDto){
        return new ResponseEntity<>(vehicleService.addVehicle(vehicleDto), HttpStatus.CREATED);
    }

    @GetMapping("/average_speed/brand/{brand}")
    public ResponseEntity<?> getAverageSpeedByBrand(@PathVariable String brand){
        return ResponseEntity.ok(vehicleService.searchAverageSpeedByBrand(brand));
    }

    @GetMapping("/dimensions")
    public ResponseEntity<?> getVehiclesByDimensions(@RequestParam String height, @RequestParam String width){
        return ResponseEntity.ok(vehicleService.searchVehiclesByDimensions(height, width));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(vehicleService.removeById(id), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}/update_speed")
    public ResponseEntity<?> putVehicleSpeedById(@PathVariable Long id, @RequestBody ResquestSpeedDto speed){
        return ResponseEntity.ok(vehicleService.updateSpeedById(id, speed));
    }

    @PutMapping("/{id}/update_fuel")
    public ResponseEntity<?> putFuelById(@PathVariable Long id, @RequestBody RequestFuelDto fuelDto){
        return ResponseEntity.ok(vehicleService.updateFuelTypeById(id, fuelDto));
    }

    @GetMapping("/brand/{brand}/between/{startYear}/{endYear}")
    public ResponseEntity<?> getVehiclesByBrandAndYear(@PathVariable String brand,
                                                       @PathVariable int startYear, @PathVariable int endYear){
        return ResponseEntity.ok(vehicleService.searchByBrandAndYear(brand, startYear, endYear));

    }

    @GetMapping("/average_capacity/brand/{brand}")
    public ResponseEntity<?> getAverageCapacityByBrand(@PathVariable String brand){
        return ResponseEntity.ok(vehicleService.searchAverageCapacityByBrand(brand));
    }

    @GetMapping("/color/{color}/year/{year}")
    public ResponseEntity<?> getVehiclesByYearAndBrand(@PathVariable String color, @PathVariable int year){
        return ResponseEntity.ok(vehicleService.searchByYearAndBrand(color, year));
    }

    @GetMapping("/fuel_type/{type}")
    public ResponseEntity<?> getVehiclesByFuelType(@PathVariable String fuelType){
        return ResponseEntity.ok(vehicleService.searchByFuelType(fuelType));
    }

}

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

    //Exercise 1
    @PostMapping("/vehicles")
    public ResponseEntity<?> addVehicle(@RequestBody VehicleDto vehicleDto){
        service.addVehicle(vehicleDto);
        return new ResponseEntity<>("CREACIÓN EXITOSA",HttpStatus.CREATED);
    }

    //Exercise 2
    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<?> findVehicleByColorAndYear(@PathVariable String color,
                                                       @PathVariable int year){
        return new ResponseEntity<>(service.findByColorAndYear(color,year),HttpStatus.OK);
    }
    //Exercise 3
    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> findVehicleByBrandAndRangerYears(@PathVariable String brand,
                                                              @PathVariable int start_year,
                                                              @PathVariable int end_year){
        return new ResponseEntity<>(service.findByBrandAndRangerYears(brand,start_year,end_year),HttpStatus.OK);
    }

    //Exercise 4
    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> calculateSpeedAverage(@PathVariable String brand){
        return new ResponseEntity<>(service.calculateSpeedAverage(brand),HttpStatus.OK);
    }
    //Exercise 5
    @PostMapping("/vehicles/batch")
    public ResponseEntity<?> addSeveralVehicles(@RequestBody List<VehicleDto> vehicleDtoList){
        service.addSeveralVehicles(vehicleDtoList);
        return new ResponseEntity<>("AGREGADOS EXITOSAMENTE. ",HttpStatus.OK);
    }
    //Eexercise 6
    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?> updateSpeed(@PathVariable long id,
                                         @RequestParam int speed){
        return new ResponseEntity<>(service.updateSpeed(id,speed),HttpStatus.OK);
    }

    //Exercise 7
    @GetMapping("/vehicles/fuel_type/{type}")
    public ResponseEntity<?> findByTypeFuel(@PathVariable String type){
        return new ResponseEntity<>(service.findByTypeFuel(type),HttpStatus.OK);
    }

    //Exercise 8
    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<?> deleteVihicle(@PathVariable long id){
        service.deleteVehicle(id);
        return new ResponseEntity<>("ELIMINACION EXITOSA",HttpStatus.OK);
    }

    //Exercise 9
    @GetMapping("/vehicles/transmission/{type}")
    public ResponseEntity<?> findByTranmission(@PathVariable String type){
        return new ResponseEntity<>(service.findByTransmission(type),HttpStatus.OK);
    }

    //Exercise 10
    @PutMapping("/vehicles/{id}/update_fuel")
    public ResponseEntity<?> updateFuel(@PathVariable long id,
                                        @RequestParam String fuel){
        return new ResponseEntity<>(service.updateFuel(id,fuel),HttpStatus.OK);
    }

    //Exercise 11
    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<?> averagePeoPleByBrand(@PathVariable String brand){
        return new ResponseEntity<>(service.averagePeopleByBrand(brand),HttpStatus.OK);
    }

    //Exercise 12
    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<?> findByLengthAndWidth(@RequestParam String length,
                                                  @RequestParam String width){
        return new ResponseEntity<>(service.findLengthAndWidth(length,width),HttpStatus.OK);
    }

    //Exercise 13
    @GetMapping("/vehicles/weight")
    public ResponseEntity<?> findByWeigth(@RequestParam Double min,
                                          @RequestParam Double max){
        return new ResponseEntity<>(service.findRangeByWeigth(min,max),HttpStatus.OK);
    }


}

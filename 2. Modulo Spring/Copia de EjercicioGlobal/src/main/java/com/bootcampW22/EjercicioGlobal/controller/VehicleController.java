package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.UpdateFuelDto;
import com.bootcampW22.EjercicioGlobal.dto.UpdateSpeedDto;
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

    //1) Añadir un vehículo
    @PostMapping("/vehicles")
    public ResponseEntity<?> postVehicle(@RequestBody VehicleDto v){
        service.addVehicle(v);
        return ResponseEntity.status(201).body("Vehiculo con Id: " + v.getId()+" creado exitosamente");
    }

    //2) Buscar vehículos por color y año
    @GetMapping("/vehicles/color/{color}/year/{year}")
    public List<VehicleDto> searchColorAndYear(
            @PathVariable String color,
            @PathVariable int year){
        return service.searchColorAndYear(color, year);
    }

    //Ejercicio 3
    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<?> ejercicio3(@PathVariable String brand,
                                       @PathVariable int start_year,
                                       @PathVariable int end_year){

        return new ResponseEntity<>(service.getVehicleBrandAndYears(brand,start_year,end_year),HttpStatus.OK);
    }

    //Ejercicio 4
    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<?> getVelocidadPromedio(@PathVariable String brand){
        return new ResponseEntity<>(service.getVelocidadPromedio(brand),HttpStatus.OK);
    }

    //Ejercicio 5
    @PostMapping("/vehicles/batch")
    public ResponseEntity<?> addListVehicle(@RequestBody List<VehicleDto> vehicleDtoList){
        service.addListVehicle(vehicleDtoList);
        return ResponseEntity.status(201).body("Lista añadida exitosamente");
    }

    //Ejercicio 6
    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<?> updateSpeed(@PathVariable int id,
                                         @RequestBody UpdateSpeedDto speedDto){
        service.updateSpeed(id,speedDto);
        return ResponseEntity.status(HttpStatus.OK).body("Actualización exitosa");

    }

    //Ejercicio 7
    @GetMapping("/vehicles/fuel_type/{type}")
    public ResponseEntity<?> findTypeFuel(@PathVariable String type){
        return new ResponseEntity<>(service.findTypeFuel(type),HttpStatus.OK);
    }

    // Ejercicio 8
    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable int id){
        service.deleteVehicle(id);
        return ResponseEntity.status(HttpStatus.OK).body("Eliminado exitosamente");
    }

    //Ejercicio 9
    @GetMapping("/vehicles/transmission/{type}")
    public ResponseEntity<?> findTransmission(@PathVariable String type){
        return new ResponseEntity<>(service.findTransmission(type),HttpStatus.OK);
    }

    //Ejercicio 10
    @PutMapping("/vehicles/{id}/update_fuel")
    public ResponseEntity<?> updateFuel(@PathVariable int id,
                                        @RequestBody UpdateFuelDto updateFuel){
        service.updateFuel(id,updateFuel);
        return ResponseEntity.status(HttpStatus.OK).body("Actualizado Exitosamente");
    }

    //Ejercicio 11
    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<?> promedioCountPersonas(@PathVariable String brand){
        return new ResponseEntity<>(service.promedioCountPersonas(brand),HttpStatus.OK);
    }

    //Ejercicio 12
    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<?> findDimenciones(@RequestParam String length,
                                            @RequestParam String width){
        return new ResponseEntity<>(service.findDimenciones(length,width),HttpStatus.OK);

    }

    //Ejercicio 13
    @GetMapping("/vehicles/weight")
    public ResponseEntity<?> findByWeigth(@RequestParam Double min, @RequestParam Double max){
        return new ResponseEntity<>(service.findByWeigth(min,max),HttpStatus.OK);
    }
}

package com.bootcampW22.EjercicioGlobal.controller;

import com.bootcampW22.EjercicioGlobal.dto.ExceptionDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
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

    @PostMapping("/vehicles")
    public ResponseEntity<String> addVehicle(@RequestBody VehicleDto vehicleDto){
        vehicleService.addVehicle(vehicleDto);
        return new ResponseEntity<>("Se ha añadido correctamente el vehiculo al concesionario", HttpStatus.OK);
    }

    @GetMapping("/vehicles/color/{color}/year/{year}")
    public ResponseEntity<List<VehicleDto>> findVehiclesByColorAndYear(@PathVariable String color, @PathVariable int year){
        return new ResponseEntity<>(vehicleService.findVehiclesByColorAndYear(color,year), HttpStatus.OK);
    }

    @GetMapping("/vehicles/brand/{brand}/between/{start_year}/{end_year}")
    public ResponseEntity<List<VehicleDto>> findVehiclesByBrandAndBeetweenYears(@PathVariable String brand, @PathVariable int start_year,
                                                                                @PathVariable int end_year){

        return new ResponseEntity<>(vehicleService.findVehiclesByBrandAndBeetweenYears(brand,start_year,end_year),
                HttpStatus.OK);
    }

    @GetMapping("/vehicles/average_speed/brand/{brand}")
    public ResponseEntity<String> checkAverageSpeedByBrand(@PathVariable String brand){
        return new ResponseEntity<>("La velocidad promedio de los carros de marca "+brand+
                " es: "+vehicleService.checkAverageSpeedByBrand(brand)+" km/h",HttpStatus.OK);
    }

    @PostMapping("/vehicles/batch")
    public ResponseEntity<List<VehicleDto>> addVehicleList(@RequestBody List<VehicleDto> vehicleDtoList){
        return new ResponseEntity<>(vehicleService.addVehicleList(vehicleDtoList),HttpStatus.CREATED);
    }

    @PutMapping("/vehicles/{id}/update_speed")
    public ResponseEntity<List<VehicleDto>> updateSpeedByVehicle(@PathVariable int id, @RequestBody VehicleDto vehicleDto){
        return new ResponseEntity<>(vehicleService.updateSpeedByVehicle(id,vehicleDto),HttpStatus.OK);
    }

    @GetMapping("/vehicles/fuel_type/{type}")
    public ResponseEntity<List<VehicleDto>> findAllByFuelType(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.findAllByFuelType(type), HttpStatus.OK);
    }

    @DeleteMapping("/vehicles/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable int id){
        vehicleService.deleteVehicle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/vehicles/transmission/{type}")
    public ResponseEntity<List<VehicleDto>>  findAllByTransmissionType(@PathVariable String type){
        return new ResponseEntity<>(vehicleService.findAllByTransmissionType(type),HttpStatus.OK);
    }

    @PutMapping("/vehicles/{id}/update_fuel")
    public ResponseEntity<String> updateFuelTypeByVehicle(@PathVariable int id, @RequestBody VehicleDto vehicleDto){
        vehicleService.updateFuelTypeByVehicle(id,vehicleDto);
        return new ResponseEntity<>("Se ha actualizado correctamente el vehiculo con id: "+id,HttpStatus.OK);
    }

    @GetMapping("/vehicles/average_capacity/brand/{brand}")
    public ResponseEntity<String> getAverageCapacityPeoplePerBrand(@PathVariable String brand){
        return new ResponseEntity<>("El promedio de capacidad total de pasajeros de la marca "+brand+
                " es "+vehicleService.getAverageCapacityPeoplePerBrand(brand),HttpStatus.OK);
    }

    @GetMapping("/vehicles/dimensions")
    public ResponseEntity<List<VehicleDto>> findVehiclesPerWidthAndLengthRange(@RequestParam String length,
                                                                               @RequestParam String width){
            String[] lengthRange = length.split("-");
            String[] widthRange = width.split("-");

            return new ResponseEntity<>(vehicleService.findVehiclesPerWidthAndLengthRange(Double.parseDouble(lengthRange[0]),
                    Double.parseDouble(lengthRange[1]),
                    Double.parseDouble(widthRange[0]),
                    Double.parseDouble(widthRange[1])),HttpStatus.OK) ;
    }

    @GetMapping("/vehicles/weight")
    public ResponseEntity<List<VehicleDto>> findVehiclesPerWeightRange(@RequestParam Double weightMin,
                                                       @RequestParam Double weightMax){
        return new ResponseEntity<>(vehicleService.findVehiclesPerWeightRange(weightMin,weightMax),HttpStatus.OK);
    }
}

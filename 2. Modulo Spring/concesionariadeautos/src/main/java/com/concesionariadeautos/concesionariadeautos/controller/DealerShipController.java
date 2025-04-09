package com.concesionariadeautos.concesionariadeautos.controller;

import com.concesionariadeautos.concesionariadeautos.dto.VehicleDTO;
import com.concesionariadeautos.concesionariadeautos.dto.VehiclesDateDTO;
import com.concesionariadeautos.concesionariadeautos.dto.VehiclesOffServiceResponseDTO;
import com.concesionariadeautos.concesionariadeautos.dto.VehiclesPriceDTO;
import com.concesionariadeautos.concesionariadeautos.service.DealershipServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("v1/api/vehicles/")
public class DealerShipController {

    @Autowired
    DealershipServiceImpl dealershipService;

    @PostMapping
    public void addVehicle(@RequestBody VehicleDTO v){
        dealershipService.addVehicle(v);
    }

    @GetMapping
    public ResponseEntity<?> getListVehiclesOffService(){
        if(dealershipService.getListVehiclesOffService().isEmpty()){
            return ResponseEntity.status(404).body("No hay nada para mostrar");
        }else
        {
            return ResponseEntity.ok(dealershipService.getListVehiclesOffService());
        }
    }

    @GetMapping("dates")
    public ResponseEntity<?> getListVehicleDate(
            @RequestParam ("since") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date since,
            @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to){
        if(dealershipService.getListVehiclesDate(since,to).isEmpty())
        {
            return ResponseEntity.status(404).body("No se encontro vehiculos desde "+since+" hasta "+to);
        }else{
            return ResponseEntity.ok(dealershipService.getListVehiclesDate(since,to));
        }
    }

    @GetMapping("prices")
    public ResponseEntity<?> getListVehiclesPrice(@RequestParam("since") Double since,
                                                       @RequestParam("to") Double to) {
        if(dealershipService.getListVehiclesPrice(since,to).isEmpty()){
            return ResponseEntity.status(404).body("Vehiculos no encontrados en el rango dado");
        }else{
            return ResponseEntity.ok(dealershipService.getListVehiclesPrice(since,to));
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getVehicle(@PathVariable Long id)
    {
        VehicleDTO vehicle = dealershipService.getVehicleId(id);
        if (vehicle != null) {
            return ResponseEntity.ok(vehicle);
        } else {
            return ResponseEntity.status(404).body("No se encuentra vehiculo con Id: " + id);
        }
    }
}

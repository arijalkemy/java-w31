package com.mercadolibre.hql_query.controller;

import com.mercadolibre.hql_query.entity.Vehiculo;
import com.mercadolibre.hql_query.service.IVehiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculo")
public class VehiculoController {

    private final IVehiculoService vehiculoService;

    public VehiculoController(IVehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }

    @GetMapping
    public ResponseEntity<List<Vehiculo>> listarPatentes(){
        return new ResponseEntity<>(vehiculoService.listarPatentes(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Vehiculo> crearVehiculo(@RequestBody Vehiculo vehiculo){
        return new ResponseEntity<>(vehiculoService.crearVehiculo(vehiculo), HttpStatus.CREATED);
    }

}

package com.example.hqlenvivo.controller;

import com.example.hqlenvivo.model.CreateVehicleRequest;
import com.example.hqlenvivo.model.Vehiculo;
import com.example.hqlenvivo.model.VehiculoSiniestro;
import com.example.hqlenvivo.service.VehicleService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehiculos")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehiculoService;

    @PostMapping
    public ResponseEntity<Vehiculo> createVehiculo(@RequestBody Vehiculo v) {
        return ResponseEntity.ok(vehiculoService.save(v));
    }

    @GetMapping
    public ResponseEntity<List<Vehiculo>> getAll() {
        return ResponseEntity.ok(vehiculoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> get(@PathVariable Long id) {
        return vehiculoService.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Consultas HQL

    @GetMapping("/patentes")
    public List<String> getPatentes() {
        return vehiculoService.getAllPatentes();
    }

    @GetMapping("/patente-marca")
    public List<Object[]> getPatenteMarca() {
        return vehiculoService.getPatenteMarcaOrdenAnio();
    }

    @GetMapping("/patentes-ruedas-anio")
    public List<String> getPatentesRuedasAnio(@RequestParam int anio) {
        return vehiculoService.getPatentesRuedasAnio(anio);
    }

    @GetMapping("/siniestrados-grande")
    public List<Object[]> getVehiculosPorSiniestroGrande(@RequestParam(defaultValue = "10000") double monto) {
        return vehiculoService.getVehiculosPorSiniestroGrande(monto);
    }

    @GetMapping("/perdida-total")
    public List<VehiculoSiniestro> getVehiculosConPerdidaTotal(@RequestParam(defaultValue = "10000") double monto) {
        return vehiculoService.getVehiculoSiniestroConPerdida(monto);
    }
}

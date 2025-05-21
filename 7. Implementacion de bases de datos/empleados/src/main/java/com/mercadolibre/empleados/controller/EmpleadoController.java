package com.mercadolibre.empleados.controller;

import com.mercadolibre.empleados.domain.Empleado;
import com.mercadolibre.empleados.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/empresa")
public class EmpleadoController {
    @Autowired
    IEmpleadoService service;
    @PostMapping
    public ResponseEntity<String> saveEmployee(@RequestBody Empleado empleado) {
        service.saveEmployee(empleado);
        return ResponseEntity.ok("Empleado creado correctamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable String id, @RequestBody Empleado empleado) {
        service.updateEmployee(id, empleado);
        return ResponseEntity.ok("Empleado actualizado correctamente");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getEmployeeById(@PathVariable String id) {
        return new ResponseEntity<>(service.getEmployeeById(id), HttpStatus.OK);
    }
}

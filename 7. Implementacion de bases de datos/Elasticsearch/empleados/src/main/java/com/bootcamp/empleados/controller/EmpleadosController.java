package com.bootcamp.empleados.controller;

import com.bootcamp.empleados.dto.EmpleadoDto;
import com.bootcamp.empleados.service.IEmpleadoService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/employees")
public class EmpleadosController {
    private final IEmpleadoService service;

    public EmpleadosController(IEmpleadoService service) {
        this.service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<EmpleadoDto>> getAllEmployees() {
        return new ResponseEntity<>(service.getAllEmployees(), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<String> postNewEmployee(@RequestBody EmpleadoDto emloyee) {
        return new ResponseEntity<>(service.createEmployee(emloyee), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable String id, @RequestBody EmpleadoDto employee) {
        return new ResponseEntity<>(service.updateEmployee(id, employee), HttpStatus.OK);
    }
}

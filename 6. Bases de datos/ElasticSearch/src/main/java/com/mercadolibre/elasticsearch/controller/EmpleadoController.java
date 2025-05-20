package com.mercadolibre.elasticsearch.controller;

import com.mercadolibre.elasticsearch.dto.EmpleadoDto;
import com.mercadolibre.elasticsearch.model.Empleado;
import com.mercadolibre.elasticsearch.service.EmpleadoService;
import com.mercadolibre.elasticsearch.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {
    @Autowired
    EmpleadoService empleadoService;

    @PostMapping("/new")
    public ResponseEntity<Empleado> save(@RequestBody EmpleadoDto empleado) {
        return new ResponseEntity<>(empleadoService.save(empleado), HttpStatus.CREATED);
    }
}

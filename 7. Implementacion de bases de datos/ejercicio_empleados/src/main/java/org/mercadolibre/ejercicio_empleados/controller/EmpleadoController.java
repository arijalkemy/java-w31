package org.mercadolibre.ejercicio_empleados.controller;

import lombok.AllArgsConstructor;
import org.mercadolibre.ejercicio_empleados.dto.EmpleadoDTO;
import org.mercadolibre.ejercicio_empleados.service.EmpleadoServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
@AllArgsConstructor
public class EmpleadoController {

    private final EmpleadoServiceImpl service;

    @GetMapping
    public List<EmpleadoDTO> getAllEmployees(){
        return  service.getAllEmployees();
    }

    @PostMapping("/create")
    public EmpleadoDTO crearEmpleado(@RequestBody EmpleadoDTO empleadoDTO) {
        return service.createEmployee(empleadoDTO);
    }

}

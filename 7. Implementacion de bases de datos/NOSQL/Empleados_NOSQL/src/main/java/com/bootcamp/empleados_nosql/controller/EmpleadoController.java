package com.bootcamp.empleados_nosql.controller;

import com.bootcamp.empleados_nosql.model.Empleado;
import com.bootcamp.empleados_nosql.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    private final EmpleadoService service;

    @Autowired
    public EmpleadoController(EmpleadoService service) {
        this.service = service;
    }

    @PostMapping
    public Empleado crearEmpleado(@RequestBody Empleado empleado) {
        return service.guardarEmpleado(empleado);
    }
// chequeo en http://localhost:9200/empleados/_search?pretty
    @PutMapping("/{id}")
    public Empleado actualizarEmpleado(@PathVariable String id, @RequestBody Empleado empleado) {
        empleado.setId(id);
        return service.actualizarEmpleado(empleado);
    }
}

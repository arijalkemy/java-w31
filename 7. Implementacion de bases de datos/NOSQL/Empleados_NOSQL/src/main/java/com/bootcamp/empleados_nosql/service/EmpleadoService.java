package com.bootcamp.empleados_nosql.service;

import com.bootcamp.empleados_nosql.model.Empleado;
import com.bootcamp.empleados_nosql.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoService {

    private final EmpleadoRepository repository;

    @Autowired
    public EmpleadoService(EmpleadoRepository repository) {
        this.repository = repository;
    }

    public Empleado guardarEmpleado(Empleado empleado) {
        return repository.save(empleado);
    }

    public Empleado actualizarEmpleado(Empleado empleado) {
        return repository.save(empleado);
    }
}

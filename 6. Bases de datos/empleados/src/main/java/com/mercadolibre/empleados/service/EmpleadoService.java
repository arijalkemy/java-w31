package com.mercadolibre.empleados.service;

import com.mercadolibre.empleados.domain.Empleado;
import com.mercadolibre.empleados.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpleadoService implements IEmpleadoService {
    @Autowired
    EmpleadoRepository repository;

    @Override
    public void saveEmployee(Empleado empleado) {
        repository.save(empleado);
    }

    @Override
    public void updateEmployee(String id, Empleado empleado) {
        Empleado empleadoObtained = this.getEmployeeById(id);
        empleadoObtained.setNombre(empleado.getNombre());
        empleadoObtained.setApellido(empleado.getApellido());
        empleadoObtained.setCiudad(empleado.getCiudad());
        empleadoObtained.setProvincia(empleado.getProvincia());
        repository.save(empleadoObtained);
    }

    @Override
    public Empleado getEmployeeById(String id) {
            return repository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Empleado no encontrado con ID: " + id));
        }
}

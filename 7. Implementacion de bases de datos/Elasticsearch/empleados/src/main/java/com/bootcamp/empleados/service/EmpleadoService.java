package com.bootcamp.empleados.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.bootcamp.empleados.domain.Empleado;
import com.bootcamp.empleados.dto.EmpleadoDto;
import com.bootcamp.empleados.exception.BadRequestException;
import com.bootcamp.empleados.exception.EmpleadoNotFoundException;
import com.bootcamp.empleados.repository.EmpleadoRepository;

@Service
public class EmpleadoService implements IEmpleadoService {
    private final EmpleadoRepository repository;

    public EmpleadoService(EmpleadoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EmpleadoDto> getAllEmployees() {
        List<EmpleadoDto> dtos = new ArrayList<>();
        Iterable<Empleado> empleados = repository.findAll();

        for (Empleado empleado : empleados) {
            dtos.add(EmpleadoDto.fromEntity(empleado));
        }

        if (dtos.isEmpty()) {
            throw new EmpleadoNotFoundException("No se encontraron empleados.");
        }
        return dtos;
    }

    @Override
    public String createEmployee(EmpleadoDto employeeDto) {
        if (employeeDto == null) {
            throw new BadRequestException("Datos para crear empleado inválidos.");
        }

        Empleado employee = employeeDto.toEntity();
        Empleado savedEmployee = repository.save(employee);
        return savedEmployee.getId();
    }

    @Override
    public String updateEmployee(String id, EmpleadoDto employeeDto) {
        if (employeeDto == null) {
            throw new BadRequestException("Datos para actualizar empleado inválidos.");
        }

        Optional<Empleado> optionalEmployee = repository.findById(id);
        Empleado employee = optionalEmployee.orElseThrow(
                () -> new EmpleadoNotFoundException("No se encontró empleado de id " + id));

        employee.setNombre(employeeDto.getNombre());
        employee.setApellido(employeeDto.getApellido());
        employee.setEdad(employeeDto.getEdad());
        employee.setCiudad(employeeDto.getCiudad());
        employee.setProvincia(employeeDto.getProvincia());

        repository.save(employee);
        return "Empleado actualizado con éxito";
    }

}

package com.bootcamp.empleados.service;

import java.util.List;

import com.bootcamp.empleados.dto.EmpleadoDto;

public interface IEmpleadoService {
    public List<EmpleadoDto> getAllEmployees();

    public String createEmployee(EmpleadoDto emloyee);

    public String updateEmployee(String id, EmpleadoDto employee);
}

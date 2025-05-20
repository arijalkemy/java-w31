package org.mercadolibre.ejercicio_empleados.service;

import org.mercadolibre.ejercicio_empleados.dto.EmpleadoDTO;

import java.util.List;

public interface EmpleadoService {

    EmpleadoDTO createEmployee(EmpleadoDTO empleado);

    List<EmpleadoDTO> getAllEmployees();
}

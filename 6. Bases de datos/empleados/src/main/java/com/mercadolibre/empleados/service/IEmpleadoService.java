package com.mercadolibre.empleados.service;

import com.mercadolibre.empleados.domain.Empleado;

public interface IEmpleadoService {
    void saveEmployee(Empleado empleado);
    void updateEmployee(String id, Empleado empleado);
    Empleado getEmployeeById(String id);
}

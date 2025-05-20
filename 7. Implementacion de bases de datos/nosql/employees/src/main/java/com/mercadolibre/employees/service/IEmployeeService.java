package com.mercadolibre.employees.service;

import com.mercadolibre.employees.model.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee addEmployee(Employee employee);
    
    String editEmployee(Employee employee);

    List<Employee> findAll();
}

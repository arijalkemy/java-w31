package com.mercadolibre.employees.service;

import com.mercadolibre.employees.model.Employee;
import com.mercadolibre.employees.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public String editEmployee(Employee employee) {
        employeeRepository.save(employee);
        return "Employee edited successfully";
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}

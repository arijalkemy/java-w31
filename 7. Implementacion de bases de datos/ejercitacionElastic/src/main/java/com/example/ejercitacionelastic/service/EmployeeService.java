package com.example.ejercitacionelastic.service;

import com.example.ejercitacionelastic.model.Employee;
import com.example.ejercitacionelastic.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {

    private EmployeeRepository repository;

    public Employee addEmployee(Employee newEmployee) {
        return repository.save(newEmployee);
    }

    public Employee getEmployee(String id) {
        Optional<Employee> employee = repository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new RuntimeException();
        }
    }
}

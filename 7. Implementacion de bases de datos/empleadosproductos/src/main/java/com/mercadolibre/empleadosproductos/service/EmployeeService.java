package com.mercadolibre.empleadosproductos.service;

import com.mercadolibre.empleadosproductos.dto.EmployeeDTO;
import com.mercadolibre.empleadosproductos.model.Employee;
import com.mercadolibre.empleadosproductos.repository.IEmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final IEmployeeRepository employeeRepository;

    public Employee createEmployee(EmployeeDTO dto) {
        Employee employee = Employee.builder()
                .id(UUID.randomUUID().toString())
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .age(dto.getAge())
                .city(dto.getCity())
                .state(dto.getState())
                .build();
        return employeeRepository.save(employee);
    }

    public Optional<Employee> updateEmployee(String id, EmployeeDTO dto) {
        return employeeRepository.findById(id).map(existing -> {
            existing.setFirstName(dto.getFirstName());
            existing.setLastName(dto.getLastName());
            existing.setAge(dto.getAge());
            existing.setCity(dto.getCity());
            existing.setState(dto.getState());
            return employeeRepository.save(existing);
        });
    }
}

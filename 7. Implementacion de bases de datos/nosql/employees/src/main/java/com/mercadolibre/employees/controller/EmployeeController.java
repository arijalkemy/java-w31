package com.mercadolibre.employees.controller;

import com.mercadolibre.employees.model.Employee;
import com.mercadolibre.employees.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/employee/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK);
    }

    @PutMapping("/employee/edit")
    public ResponseEntity<String> editEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.editEmployee(employee), HttpStatus.OK);
    }
}

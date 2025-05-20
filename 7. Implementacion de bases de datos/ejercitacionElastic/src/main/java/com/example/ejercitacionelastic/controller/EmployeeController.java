package com.example.ejercitacionelastic.controller;

import com.example.ejercitacionelastic.model.Employee;
import com.example.ejercitacionelastic.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService service;

    @PostMapping("/employee")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(service.addEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<?> getEmployeeByID(@PathVariable String id) {
        return new ResponseEntity<>(service.getEmployee(id), HttpStatus.OK);
    }

}

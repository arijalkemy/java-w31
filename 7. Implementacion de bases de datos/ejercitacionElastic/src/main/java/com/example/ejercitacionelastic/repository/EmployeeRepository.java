package com.example.ejercitacionelastic.repository;

import com.example.ejercitacionelastic.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {
}

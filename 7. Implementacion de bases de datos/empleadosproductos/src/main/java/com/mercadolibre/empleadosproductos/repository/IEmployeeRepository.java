package com.mercadolibre.empleadosproductos.repository;

import com.mercadolibre.empleadosproductos.model.Employee;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IEmployeeRepository extends ElasticsearchRepository<Employee, String> {
}


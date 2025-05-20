package com.bootcamp.empleados.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.empleados.domain.Empleado;

@Repository
public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, String> {
}
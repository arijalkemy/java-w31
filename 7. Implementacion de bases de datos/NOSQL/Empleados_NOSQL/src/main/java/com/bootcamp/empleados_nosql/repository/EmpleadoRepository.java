package com.bootcamp.empleados_nosql.repository;

import com.bootcamp.empleados_nosql.model.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, String> {
}

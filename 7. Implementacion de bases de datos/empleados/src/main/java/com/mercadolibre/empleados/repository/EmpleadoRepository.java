package com.mercadolibre.empleados.repository;

import com.mercadolibre.empleados.domain.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, String> {

}

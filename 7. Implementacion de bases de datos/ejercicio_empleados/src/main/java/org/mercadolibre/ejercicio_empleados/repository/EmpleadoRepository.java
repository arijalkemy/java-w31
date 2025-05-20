package org.mercadolibre.ejercicio_empleados.repository;

import org.mercadolibre.ejercicio_empleados.entities.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, Long> {
}

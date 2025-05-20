package com.mercadolibre.elasticsearch.repository;

import com.mercadolibre.elasticsearch.model.Empleado;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado, Long> {
}

package com.mercadolibre.empleados.repository;

import com.mercadolibre.empleados.domain.Producto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProdutRepository extends ElasticsearchRepository<Producto, String> {
}

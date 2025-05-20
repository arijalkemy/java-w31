package com.mercadolibre.empleadosproductos.repository;

import com.mercadolibre.empleadosproductos.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IProductRepository extends ElasticsearchRepository<Product, String> {
}

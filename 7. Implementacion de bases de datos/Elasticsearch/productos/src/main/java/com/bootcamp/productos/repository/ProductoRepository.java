package com.bootcamp.productos.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.productos.domain.Producto;

@Repository
public interface ProductoRepository extends ElasticsearchRepository<Producto, String> {
}
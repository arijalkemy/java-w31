package com.bootcamp.productos_nosql.repository;

import com.bootcamp.productos_nosql.model.Producto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends ElasticsearchRepository<Producto,String> {
}

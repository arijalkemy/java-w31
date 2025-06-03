package com.example.elastic.repository;

import com.example.elastic.entities.Articulo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticuloRepository extends ElasticsearchRepository<Articulo, String> {
} 
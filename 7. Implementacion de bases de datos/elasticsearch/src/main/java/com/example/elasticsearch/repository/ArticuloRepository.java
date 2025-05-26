package com.example.elasticsearch.repository;

import com.example.elasticsearch.entity.Articulo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ArticuloRepository extends ElasticsearchRepository<Articulo, String> {
    List<Articulo> findAllByTituloContainingIgnoreCase(String title);
}

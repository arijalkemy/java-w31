package com.showroom.extra.repository;

import com.showroom.extra.model.Prenda;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPrendaRepository extends ElasticsearchRepository<Prenda,String> {

    List<Prenda> findAllByTalle(@Param("talle") String talle);

    List<Prenda> findByNombreContainingIgnoreCase(String nombre);

    List<Prenda> findAll();
}

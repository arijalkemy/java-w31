package com.bootcamp.obrasliterarias.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.obrasliterarias.domain.ObraLiteraria;

@Repository
public interface ObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {
    public Iterable<ObraLiteraria> findByAutor(String autor);

    public Iterable<ObraLiteraria> findByNombre(String nombre);

    public Iterable<ObraLiteraria> findByEditorial(String editorial);

    public Iterable<ObraLiteraria> findByAnioPublicacionBefore(Integer anio);
}
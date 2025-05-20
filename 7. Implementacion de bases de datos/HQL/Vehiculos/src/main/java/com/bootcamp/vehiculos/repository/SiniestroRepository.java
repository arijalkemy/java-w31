package com.bootcamp.vehiculos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.vehiculos.model.Siniestro;

@Repository
public interface SiniestroRepository extends CrudRepository<Siniestro, Long> {
}

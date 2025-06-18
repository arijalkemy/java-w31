package com.example.empresaseguros.repository;

import com.example.empresaseguros.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ISiniestroRepository extends JpaRepository<Siniestro,Long> {
}

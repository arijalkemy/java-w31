package com.example.hqlenvivo.repository;

import com.example.hqlenvivo.model.Siniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SinisterRepository extends JpaRepository<Siniestro, Long> {
    List<Siniestro> findByVehiculoId(Long vehiculoId);
}

package com.mercadolibre.showroom.repository;

import com.mercadolibre.showroom.model.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PrendaRepository extends JpaRepository<Prenda, Long> {

    boolean existsPrendaByCodigo(String codigo);

    Optional<Prenda> findByCodigo(String codigo);

    List<Prenda> findAllByTalle(String talle);

    List<Prenda> findByNombreContainingIgnoreCase(String nombre);
}

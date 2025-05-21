package com.showroom.extra.repository;

import com.showroom.extra.model.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPrendaRepository extends JpaRepository<Prenda,Long> {

    @Query("SELECT p FROM Prenda p WHERE LOWER(p.talle) = LOWER(:talle)")
    List<Prenda> findAllByTalle(@Param("talle") String talle);

    List<Prenda> findByNombreContainingIgnoreCase(String nombre);
}

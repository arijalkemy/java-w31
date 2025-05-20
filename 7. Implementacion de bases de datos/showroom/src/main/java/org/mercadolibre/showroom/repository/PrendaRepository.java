package org.mercadolibre.showroom.repository;

import org.mercadolibre.showroom.entities.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrendaRepository extends JpaRepository<Prenda, Long> {
    @Query("SELECT p FROM Prenda p WHERE p.codigo = :code")
    Prenda getByCodigo(@Param("code") String code);

    @Query("SELECT p FROM Prenda p WHERE p.talle = :size")
    List<Prenda> getPrendaBySize(@Param("size") String size);

    @Query("SELECT p FROM Prenda p WHERE p.nombre LIKE %:name%")
    List<Prenda> findByNombre(@Param("name") String name);
}
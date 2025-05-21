package com.mercadolibre.showroom.repository;

import com.mercadolibre.showroom.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {
    boolean existsByNumero(String numero);

    Optional<Venta> findByNumero(String numero);

    List<Venta> findAllByFecha(LocalDate fecha);
}

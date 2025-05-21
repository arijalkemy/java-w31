package com.mercadolibre.showroom.repository;

import com.mercadolibre.showroom.model.DetalleVenta;
import com.mercadolibre.showroom.model.Prenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {

    @Query("SELECT d.prenda FROM DetalleVenta d WHERE d.venta.numero = :numero")
    List<Prenda> findPrendasByVentaNumero(String numero);
}

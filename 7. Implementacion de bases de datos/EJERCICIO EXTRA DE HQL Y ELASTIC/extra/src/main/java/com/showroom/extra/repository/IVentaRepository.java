package com.showroom.extra.repository;

import com.showroom.extra.model.Prenda;
import com.showroom.extra.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface IVentaRepository extends JpaRepository<Venta, Long> {
    List<Venta> findAllByFecha(LocalDate date);
}

package com.example.hqlenvivo.repository;

import com.example.hqlenvivo.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehiculo, Long> {
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findAllPatentes();

    @Query("SELECT v.patente, v.brand FROM Vehiculo v ORDER BY v.year")
    List<Object[]> findPatenteMarcaOrderByAnio();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.wheels > 4 AND v.year = :year")
    List<String> findPatentesByRuedasAndAnio(@Param("year") int year);

    @Query("""
        SELECT DISTINCT v.patente, v.brand, v.model
        FROM Vehiculo v JOIN v.siniestros s
        WHERE s.monetaryLoss > :monto
    """)
    List<Object[]> findVehiculosBySiniestroMayorA(@Param("monto") double monto);

    @Query("""
      SELECT v, SUM(s.monetaryLoss)
      FROM Vehiculo v JOIN v.siniestros s
      WHERE s.monetaryLoss > :monto
      GROUP BY v
    """)
    List<Object[]> findVehiculoYPerdidaTotalBySiniestroMayorA(@Param("monto") double monto);

}

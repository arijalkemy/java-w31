package com.HQL.demo.repository;

import com.HQL.demo.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IVehiculoRepository extends JpaRepository<Vehiculo,Long> {
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findAllPatentes(); // 1

    @Query("SELECT v.patente, v.marca FROM Vehiculo v  ORDER BY  v.anioFabricación")
    List<Object[]> findPatenteAndMarcaOrderByAnio(); // 2

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedad >= 4 AND FUNCTION('YEAR',v.anioFabricación) = :anio")
    List<String> findPatenteWithMoreThan4RuedasAndCurrentYear(@Param("anio") Integer anio); // 3

    @Query(
            "SELECT v.patente, v.marca, v.modelo FROM Vehiculo v JOIN v.siniestroList s WHERE s.perdidaEconomica >= 10000"
    )
    List<Object[]> findInfoVehiculosWithSiniestrosPerdidaMayor10000(); // 4

    @Query(
            "SELECT v, SUM(s.perdidaEconomica) AS perdidaTotal " +
                    "FROM Vehiculo v JOIN v.siniestroList s " +
                    "WHERE s.perdidaEconomica > 10000 " +
                    "GROUP BY v"
    )
    List<Object[]> findVehiculosAndTotalPerdidaMayor10000(); // 5
}

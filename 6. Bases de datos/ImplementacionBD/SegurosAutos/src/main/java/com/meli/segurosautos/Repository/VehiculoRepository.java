package com.meli.segurosautos.Repository;

import com.meli.segurosautos.Entity.Vehiculo;
import com.meli.segurosautos.Model.VehiculoSiniestro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> listarPatentes();

    @Query("SELECT v.patente, v.marca FROM Vehiculo v ORDER BY v.anioFabricacion")
    List<Object[]> listarPorAnioFabricacion();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas > 4 AND v.anioFabricacion = 2025")
    List<String> listarVehiculosConMasDeCuatroRuedasYFabricacionReciente(@Param("año") int anioActual);

    @Query("SELECT v.patente, v.marca, v.modelo FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > 10000")
    List<Object[]> listarVehiculosConSiniestroMayorA(@Param("cantidad") double cantidad);

    @Query("SELECT new com.meli.segurosautos.Model.VehiculoSiniestro(v, SUM(s.perdidaEconomica)) FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > 10000 GROUP BY v")
    List<VehiculoSiniestro> listarVehiculosConPerdidaTotalMayorA(@Param("cantidad") double cantidad);
}

package com.mercadolibre.empresaseguroshql.repository;

import com.mercadolibre.empresaseguroshql.dto.PatenteMarcaDTO;
import com.mercadolibre.empresaseguroshql.dto.VehiculoInfoDTO;
import com.mercadolibre.empresaseguroshql.dto.VehiculoSiniestroDTO;
import com.mercadolibre.empresaseguroshql.model.Vehiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehiculoRepository extends CrudRepository<Vehiculo, Long> {
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findAllPatentes();

    @Query("SELECT v.patente, v.marca FROM Vehiculo v ORDER BY v.anioFabricacion")
    List<Object[]> findPatenteAndMarcaOrderByAnio();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas > 4 AND v.anioFabricacion = :anio")
    List<String> findPatentesByRuedasAndAnio(@Param("anio") int anio);

    @Query("SELECT new com.mercadolibre.empresaseguroshql.dto.VehiculoInfoDTO(v.patente, v.marca, v.modelo) FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > 10000")
    List<VehiculoInfoDTO> findVehiculosConSiniestroMayorA10000();

//    @Query("SELECT new com.mercadolibre.empresaseguroshql.dto.VehiculoSiniestroDTO(v.patente, v.marca, v.modelo, SUM(s.perdidaEconomica)) FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > 10000 GROUP BY v.patente, v.marca, v.modelo")
//    List<VehiculoSiniestroDTO> findVehiculosConSiniestroMayorA10000YPerdidaTotal();
}

package com.bootcamp.vehiculoshql.repository;

import com.bootcamp.vehiculoshql.dto.VehiculoSiniestroDTO;
import com.bootcamp.vehiculoshql.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {
    @Query("SELECT v.patente FROM Vehiculo v")
    List<String> findAllPatentes();

    @Query("SELECT v.patente, v.marca FROM Vehiculo v ORDER BY v.anioFabricacion")
    List<Object[]> findPatenteAndMarcaOrderByAnioFabricacion();

    @Query("SELECT v.patente FROM Vehiculo v WHERE v.cantidadRuedas > 4 AND v.anioFabricacion = ?1")
    List<String> findPatenteByRuedasAndAnio(int anio);

    // Listar vehículos con pérdida mayor a 10,000
    @Query("SELECT new com.bootcamp.vehiculoshql.dto.VehiculoSiniestroDTO(v.patente, v.marca, v.modelo) " +
            "FROM Vehiculo v JOIN v.siniestros s " +
            "WHERE s.perdidaEconomica > :monto")
    List<VehiculoSiniestroDTO> getVehiculosConPerdidaMayor(@Param("monto") double monto);

    // Listar vehículos con pérdida mayor a 10,000 y pérdida total
    @Query("SELECT new com.bootcamp.vehiculoshql.dto.VehiculoSiniestroDTO(v.patente, v.marca, v.modelo, SUM(s.perdidaEconomica)) " +
            "FROM Vehiculo v JOIN v.siniestros s " +
            "WHERE s.perdidaEconomica > :monto " +
            "GROUP BY v.patente, v.marca, v.modelo")
    List<VehiculoSiniestroDTO> getVehiculosConPerdidaTotalMayor(@Param("monto") double monto);

}

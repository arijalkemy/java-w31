package com.bootcamp.vehiculos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootcamp.vehiculos.model.Vehicle;

@Repository
public interface VehiculoRepository extends CrudRepository<Vehicle, Long> {

    // 1. Listar las patentes de todos los vehículos registrados.
    @Query("SELECT v.patente FROM Vehicle v")
    List<String> findAllPatentes();

    // 2. Listar la patente y la marca de todos los vehículos ordenados por año de
    // fabricación.
    @Query("SELECT v.patente, v.marca FROM Vehicle v ORDER BY v.fechaFabricacion")
    List<Object[]> findPatenteAndMarcaOrderedByFechaFabricacion();

    // 3. Listar la patente de todos los vehículos que tengan más de cuatro ruedas y
    // hayan sido fabricados en el corriente año.
    @Query("SELECT v.patente FROM Vehicle v " +
            "WHERE v.cantidadDeRuedas > 4 AND FUNCTION('YEAR', v.fechaFabricacion) = :currentYear")
    List<String> findPatentesWithMoreThanFourWheelsManufacturedInYear(@Param("currentYear") int currentYear);

    // 4. Listar la patente, marca y modelo de todos los vehículos que
    // hayan tenido un siniestro con pérdida mayor de 10000 pesos.
    @Query("SELECT DISTINCT v.patente, v.marca, v.modelo FROM Vehicle v JOIN v.siniestros s " +
            "WHERE s.perdidaEconomica > 10000")
    List<Object[]> findVehicleBasicDataWithSiniestroLossAbove();

    // 5. Listar la matrícula, marca y modelo de todos los vehículos que hayan
    // tenido un siniestro con pérdida mayor de 10000 pesos, mostrando a cuánto
    // ascendió la pérdida total de todos ellos.
    @Query("SELECT v.patente, v.marca, v.modelo, SUM(s.perdidaEconomica) FROM Vehicle v " +
            "JOIN v.siniestros s WHERE s.perdidaEconomica > 10000 " +
            "GROUP BY v.patente, v.marca, v.modelo")
    List<Object[]> findVehicleBasicDataAndTotalSiniestroLossAbove();
}
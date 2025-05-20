package com.meli.maolaya.siniestro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.meli.maolaya.siniestro.model.Vehiculo;
import com.meli.maolaya.siniestro.model.VehiculoSiniestro;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {
    @Query("select v.patente from Vehiculo v")
    List<String> findAllPlates();

    @Query("from Vehiculo v order by v.añoFabricacion")
    List<Vehiculo> findPlatesAndBrandsOrderByYear();

    @Query("from Vehiculo v where v.añoFabricacion = 2025 and v.ruedas > 4")
    List<Vehiculo> findPlateByYearAndTires();

    @Query("from Vehiculo v join v.siniestros s where s.perdidaEconomica > 10000")
    List<Vehiculo> findByEconomicLostGreaterThan10000();

    @Query("select new com.meli.maolaya.siniestro.model.VehiculoSiniestro(v.patente, v.marca, v.modelo, sum(s.perdidaEconomica)) "
            +
            "from Vehiculo v join v.siniestros s " +
            "group by v.patente, v.marca, v.modelo " +
            "having sum(s.perdidaEconomica) > 10000")
    List<VehiculoSiniestro> findByEconomicLostGreaterThan10000Sum();
}

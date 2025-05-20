package com.mercadolibre.miniseries.repository;

import com.mercadolibre.miniseries.model.Vehicle;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRepository extends CrudRepository<Vehicle,Long> {
    @Query("select v.matricula from Vehicle v")
    List<String> getAll();

    @Query("select v from Vehicle v order by v.anoFabricacion")
    List<Vehicle> getAllOrdered();

    List<Vehicle> getAllByAnoFabricacionAndNumRuedasGreaterThan(Long anoFabricacion, Integer numRuedasAfter);

    @Query("select v from Vehicle v join v.siniestros s where s.perdida >= 1000000")
    List<Vehicle> getSinister();

    





}

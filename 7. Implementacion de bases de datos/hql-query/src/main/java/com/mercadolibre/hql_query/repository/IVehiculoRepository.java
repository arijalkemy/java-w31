package com.mercadolibre.hql_query.repository;

import com.mercadolibre.hql_query.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IVehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query("select v.patente from Vehiculo v")
    List<Vehiculo> listarPatentes();

    @Query("SELECT v.patente, v.marca FROM Vehiculo v ORDER BY v.anioFabricacion") // Default viene en ASC
    List<Vehiculo> listarPatenteMarcaPorFecha();


}

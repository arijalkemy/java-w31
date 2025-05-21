package com.mercadolibre.vehiculohql.repository;

import com.mercadolibre.vehiculohql.dto.VehiculoPatenteMarcaDTO;
import com.mercadolibre.vehiculohql.dto.VehiculoConPerdidasDTO;
import com.mercadolibre.vehiculohql.dto.VehiculoPatenteMarcaModeloDTO;
import com.mercadolibre.vehiculohql.model.Vehiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IVehiculoRepository extends CrudRepository<Vehiculo, Long> {
    @Query("select v.patente from Vehiculo v")
    List<String> getPatentesDeTodosLosVehiculos();

    @Query("select v from Vehiculo v order by v.anioDeFabricacion")
    List<Vehiculo> getPatenteYMarcaDeVehiculosOrdenadosPorAnioDeFabricacion();


    @Query("select v.patente from Vehiculo v where v.cantidadDeRuedas > 4 and v.anioDeFabricacion = :anio")
    List<String> getPatentesDeVehiculosConMasDeCuatroRuedasYAño(@Param("anio") Integer anio);

    @Query("SELECT DISTINCT v FROM Vehiculo v JOIN v.siniestros s WHERE s.perdidaEconomica > 10000")
    List<Vehiculo> getVehiculosConSiniestrosMayoresA10k();

    @Query("select v, SUM(s.perdidaEconomica) as totalPerdidas " +
            "from Vehiculo v join v.siniestros s " +
            "where s.perdidaEconomica > 10000 " +
            "group by v.id, v.patente, v.marca, v.modelo")
    List<Object[]> getVehiculosConSiniestrosMayoresA10kYPerdidaTotal();


}

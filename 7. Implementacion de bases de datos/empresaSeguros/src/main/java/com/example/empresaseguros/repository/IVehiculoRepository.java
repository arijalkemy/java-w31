package com.example.empresaseguros.repository;

import com.example.empresaseguros.dto.VehiclePatenteMarcaDto;
import com.example.empresaseguros.dto.VehiculoInfoDto;
import com.example.empresaseguros.model.Vehiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IVehiculoRepository extends CrudRepository<Vehiculo,Long> {
    @Query("select v.patente from Vehiculo v")
    List<String> buscarPatentesDeVehiculos();
    @Query("select v.patente, v.marca from Vehiculo v ORDER BY v.anioFabricacion")
    List<VehiclePatenteMarcaDto> buscarPantenteYMarcaDeVehiculosPorAnio();
    @Query("select v.patente from Vehiculo v where v.cantidadRuedas > 4 and v.anioFabricacion = 2025")
    List<String> buscarPantentesDeVehiculosMasCuatroRuedasYAnio();
    @Query("select v.patente, v.marca, v.modelo " +
            "from Vehiculo v join v.siniestros s " +
            "where s.perdidaEconomica > 10000")
    List<VehiculoInfoDto> buscarPatenteMarcaYModeloDeVehiculoPerdidaMayorADiezMil();
    @Query("select v.patente, v.marca, v.modelo, sum(s.perdidaEconomica) " +
            "from Vehiculo v join v.siniestros s" +
            " where s.perdidaEconomica > 10000 " +
            "group by v.patente, v.marca, v.modelo")
    List<VehiculoInfoDto> buscarPatenteMarcaYModeloDeVehiculoConPerdidaTotal();

}

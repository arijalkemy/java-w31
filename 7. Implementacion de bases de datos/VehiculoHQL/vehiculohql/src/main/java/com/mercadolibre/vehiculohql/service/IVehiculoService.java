package com.mercadolibre.vehiculohql.service;

import com.mercadolibre.vehiculohql.dto.VehiculoConPerdidasDTO;
import com.mercadolibre.vehiculohql.dto.VehiculoPatenteMarcaDTO;
import com.mercadolibre.vehiculohql.dto.VehiculoPatenteMarcaModeloDTO;
import com.mercadolibre.vehiculohql.model.Vehiculo;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IVehiculoService {
    List<String> getPatentesDeTodosLosVehiculos();
    List<VehiculoPatenteMarcaDTO> getPatenteYMarcaDeVehiculosOrdenadosPorAnioDeFabricacion();
    List<String> getPatentesDeVehiculosConMasDeCuatroRuedasYAño(Integer anio);
    List<VehiculoPatenteMarcaModeloDTO> getVehiculosConSiniestrosMayoresA10k();
    List<VehiculoConPerdidasDTO> getVehiculosConSiniestrosMayoresA10kYPerdidaTotal();
}

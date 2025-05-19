package com.mercadolibre.vehiculohql.service;

import com.mercadolibre.vehiculohql.dto.VehiculoConPerdidasDTO;
import com.mercadolibre.vehiculohql.dto.VehiculoPatenteMarcaDTO;
import com.mercadolibre.vehiculohql.dto.VehiculoPatenteMarcaModeloDTO;
import com.mercadolibre.vehiculohql.model.Vehiculo;
import com.mercadolibre.vehiculohql.repository.IVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculoService implements IVehiculoService{
    @Autowired
    IVehiculoRepository vehiculoRepository;
    @Override
    public List<String> getPatentesDeTodosLosVehiculos() {
        return vehiculoRepository.getPatentesDeTodosLosVehiculos();
    }

    @Override
    public List<VehiculoPatenteMarcaDTO> getPatenteYMarcaDeVehiculosOrdenadosPorAnioDeFabricacion() {
        List<Vehiculo> vehiculos = vehiculoRepository.getPatenteYMarcaDeVehiculosOrdenadosPorAnioDeFabricacion();
        return vehiculos.stream()
                .map(v -> new VehiculoPatenteMarcaDTO(v.getPatente(), v.getMarca()))
                .collect(Collectors.toList());    }

    @Override
    public List<String> getPatentesDeVehiculosConMasDeCuatroRuedasYAño(Integer anio) {
        return vehiculoRepository.getPatentesDeVehiculosConMasDeCuatroRuedasYAño(anio);
    }

    @Override
    public List<VehiculoPatenteMarcaModeloDTO> getVehiculosConSiniestrosMayoresA10k() {
        List<Vehiculo> vehiculos = vehiculoRepository.getVehiculosConSiniestrosMayoresA10k();
        return vehiculos.stream()
                .map(v -> new VehiculoPatenteMarcaModeloDTO(v.getPatente(), v.getMarca(), v.getModelo()))
                .collect(Collectors.toList());
    }

    @Override
    public List<VehiculoConPerdidasDTO> getVehiculosConSiniestrosMayoresA10kYPerdidaTotal() {
        List<Object[]> resultados = vehiculoRepository.getVehiculosConSiniestrosMayoresA10kYPerdidaTotal();

        return resultados.stream()
                .map(fila -> {
                    Vehiculo v = (Vehiculo) fila[0];
                    Double totalPerdidas = (Double) fila[1];
                    return new VehiculoConPerdidasDTO(v.getPatente(), v.getMarca(), v.getModelo(), totalPerdidas);
                })
                .collect(Collectors.toList());
    }

}

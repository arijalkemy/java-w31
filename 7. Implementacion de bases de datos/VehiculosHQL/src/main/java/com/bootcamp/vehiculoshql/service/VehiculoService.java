package com.bootcamp.vehiculoshql.service;

import com.bootcamp.vehiculoshql.dto.VehiculoSiniestroDTO;
import com.bootcamp.vehiculoshql.repository.VehiculoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoService {
    private final VehiculoRepository vehiculoRepository;

    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public List<String> obtenerPatentes() {
        return vehiculoRepository.findAllPatentes();
    }

    public List<Object[]> listarPatenteMarcaOrdenadosPorAnio() {
        return vehiculoRepository.findPatenteAndMarcaOrderByAnioFabricacion();
    }

    public List<String> listarVehiculosMasDeCuatroRuedasAnoCorriente(int anio) {
        return vehiculoRepository.findPatenteByRuedasAndAnio(anio);
    }

    public List<VehiculoSiniestroDTO> listarVehiculosConPerdidaMayor(double monto) {
        return vehiculoRepository.getVehiculosConPerdidaMayor(monto);
    }

    public List<VehiculoSiniestroDTO> listarVehiculosConPerdidaTotalMayor(double monto) {
        return vehiculoRepository.getVehiculosConPerdidaTotalMayor(monto);
    }

}

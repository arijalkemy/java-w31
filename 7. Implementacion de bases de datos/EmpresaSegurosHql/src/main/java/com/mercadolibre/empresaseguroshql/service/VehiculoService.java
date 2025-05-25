package com.mercadolibre.empresaseguroshql.service;

import com.mercadolibre.empresaseguroshql.dto.PatenteMarcaDTO;
import com.mercadolibre.empresaseguroshql.dto.VehiculoInfoDTO;
import com.mercadolibre.empresaseguroshql.dto.VehiculoSiniestroDTO;
import com.mercadolibre.empresaseguroshql.model.Vehiculo;
import com.mercadolibre.empresaseguroshql.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Year;
import java.util.List;

@Service
public class VehiculoService {
    @Autowired
    private VehiculoRepository vehiculoRepository;

    public VehiculoService(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    public List<String> listarPatentes() {
        return vehiculoRepository.findAllPatentes();
    }

    @GetMapping("/patente-marca")
    public List<Object[]> getPatenteYMarca() {
        return vehiculoRepository.findPatenteAndMarcaOrderByAnio();
    }

    public List<String> listarPatentesRuedasYAnio() {
        int anioActual = Year.now().getValue();
        return vehiculoRepository.findPatentesByRuedasAndAnio(anioActual);
    }

    public List<VehiculoInfoDTO> listarVehiculosConSiniestroMayorA10000() {
        return vehiculoRepository.findVehiculosConSiniestroMayorA10000();
    }

//    public List<VehiculoSiniestroDTO> listarVehiculosConSiniestroMayorA10000YPerdidaTotal() {
//        return vehiculoRepository.findVehiculosConSiniestroMayorA10000YPerdidaTotal();
//    }
}

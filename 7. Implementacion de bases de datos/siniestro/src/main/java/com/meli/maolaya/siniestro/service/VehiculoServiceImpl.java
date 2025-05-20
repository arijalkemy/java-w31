package com.meli.maolaya.siniestro.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meli.maolaya.siniestro.dto.VehiculoDto;
import com.meli.maolaya.siniestro.dto.VehiculoSiniestroDto;
import com.meli.maolaya.siniestro.model.Vehiculo;
import com.meli.maolaya.siniestro.model.VehiculoSiniestro;
import com.meli.maolaya.siniestro.repository.IVehiculoRepository;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

    private IVehiculoRepository vehiculoRepository;

    public VehiculoServiceImpl(IVehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }

    @Override
    public void saveVehiculo(VehiculoDto vehiculoDto) {
        Vehiculo vehiculo = Vehiculo.builder().patente(vehiculoDto.getPatente()).marca(vehiculoDto.getMarca())
                .modelo(vehiculoDto.getModelo()).añoFabricacion(vehiculoDto.getAñoFabricacion())
                .ruedas(vehiculoDto.getRuedas()).build();
        vehiculoRepository.save(vehiculo);
    }

    @Override
    public List<VehiculoDto> findPatentes() {
        List<Vehiculo> vehiculos = vehiculoRepository.findAll();
        return vehiculos.stream().map(vehiculo -> VehiculoDto.builder().patente(vehiculo.getPatente()).build())
                .toList();
    }

    @Override
    public List<VehiculoDto> findPatentesMarcasOrderByYear() {
        List<Vehiculo> vehiculos = vehiculoRepository.findPlatesAndBrandsOrderByYear();
        return vehiculos.stream()
                .map(vehiculo -> VehiculoDto.builder().patente(vehiculo.getPatente()).marca(vehiculo.getMarca())
                        .build())
                .toList();
    }

    @Override
    public List<VehiculoDto> findPatentesByRuedasAndYear() {
        List<Vehiculo> vehiculos = vehiculoRepository.findPlateByYearAndTires();
        return vehiculos.stream().map(vehiculo -> VehiculoDto.builder().patente(vehiculo.getPatente()).build())
                .toList();
    }

    @Override
    public List<VehiculoDto> findGreaterThan10000() {
        List<Vehiculo> vehiculos = vehiculoRepository.findByEconomicLostGreaterThan10000();
        return vehiculos.stream()
                .map(vehiculo -> VehiculoDto.builder().patente(vehiculo.getPatente()).marca(vehiculo.getMarca())
                        .modelo(vehiculo.getModelo())
                        .build())
                .toList();
    }

    @Override
    public Vehiculo findById(Long id) {
        return vehiculoRepository.findById(id).orElseThrow();
    }

    @Override
    public List<VehiculoSiniestroDto> findGreaterThan10000sum() {
        List<VehiculoSiniestro> vehiculosSiniestros = vehiculoRepository.findByEconomicLostGreaterThan10000Sum();
        return vehiculosSiniestros.stream()
                .map(vs -> VehiculoSiniestroDto.builder().patente(vs.getPatente()).marca(vs.getMarca())
                        .modelo(vs.getModelo()).total(vs.getTotal())
                        .build())
                .toList();
    }
}

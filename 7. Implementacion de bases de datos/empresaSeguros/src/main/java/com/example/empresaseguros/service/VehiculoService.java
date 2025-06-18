package com.example.empresaseguros.service;

import com.example.empresaseguros.dto.VehiculoDto;
import com.example.empresaseguros.repository.IVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VehiculoService implements IVehiculoService{

    @Autowired
    private IVehiculoRepository vehiculoRepo;

    @Override
    public List<VehiculoDto> obtenerVehiculos() {
        return List.of();
    }

    @Override
    public VehiculoDto crearVehiculo() {
        return null;
    }

    @Override
    public String borrarVehiculo() {
        return "";
    }

    @Override
    public VehiculoDto modificarVehiculo() {
        return null;
    }

    @Override
    public List<String> obtenerPatentesPorVehiculo() {
        return vehiculoRepo.buscarPatentesDeVehiculos();
    }
}

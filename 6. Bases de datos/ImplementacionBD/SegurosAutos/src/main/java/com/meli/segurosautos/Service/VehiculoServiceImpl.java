package com.meli.segurosautos.Service;

import com.meli.segurosautos.Model.VehiculoSiniestro;
import com.meli.segurosautos.Repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoServiceImpl implements VehiculoService {
    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public List<String> listarPatentes() {
        return vehiculoRepository.listarPatentes();
    }

    @Override
    public List<Object[]> listarPorAnioFabricacion() {
        return vehiculoRepository.listarPorAnioFabricacion();
    }

    @Override
    public List<String> listarVehiculosConMasDeCuatroRuedasYFabricacionReciente(int añoActual) {
        return vehiculoRepository.listarVehiculosConMasDeCuatroRuedasYFabricacionReciente(añoActual);
    }

    @Override
    public List<Object[]> listarVehiculosConSiniestroMayorA(double cantidad) {
        return vehiculoRepository.listarVehiculosConSiniestroMayorA(cantidad);
    }

    @Override
    public List<VehiculoSiniestro> listarVehiculosConPerdidaTotalMayorA(double cantidad) {
        return vehiculoRepository.listarVehiculosConPerdidaTotalMayorA(cantidad);
    }
}

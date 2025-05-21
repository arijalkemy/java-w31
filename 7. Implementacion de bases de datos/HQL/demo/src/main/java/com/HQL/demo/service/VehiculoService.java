package com.HQL.demo.service;

import com.HQL.demo.dto.VehiculoSiniestroDTO;
import com.HQL.demo.model.Vehiculo;
import com.HQL.demo.repository.IVehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehiculoService {
    @Autowired
    IVehiculoRepository vehiculoRepo;

    // Métodos para CRUD

    public List<String> listarPatentes() {
        return vehiculoRepo.findAllPatentes();
    }

    public List<Object[]> listarPatenteMarcaPorAnio() {
        return vehiculoRepo.findPatenteAndMarcaOrderByAnio();
    }

    public List<String> listarPatentesRuedasYAnio(int anio) {
        return vehiculoRepo.findPatenteWithMoreThan4RuedasAndCurrentYear(anio);
    }

    public List<Object[]> listarMatriculaMarcaModeloConPerdidaGrande() {
        return vehiculoRepo.findInfoVehiculosWithSiniestrosPerdidaMayor10000();
    }

    public List<VehiculoSiniestroDTO> listarVehiculosPerdidaTotal() {
        List<Object[]> datos = vehiculoRepo.findVehiculosAndTotalPerdidaMayor10000();
        List<VehiculoSiniestroDTO> res = new ArrayList<>();
        for (Object[] fila : datos) {
            res.add(new VehiculoSiniestroDTO((Vehiculo)fila[0], (Double)fila[1]));
        }
        return res;
    }
}

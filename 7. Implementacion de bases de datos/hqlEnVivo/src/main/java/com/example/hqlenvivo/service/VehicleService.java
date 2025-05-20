package com.example.hqlenvivo.service;

import com.example.hqlenvivo.model.CreateVehicleRequest;
import com.example.hqlenvivo.model.Vehiculo;
import com.example.hqlenvivo.model.VehiculoDTO;
import com.example.hqlenvivo.model.VehiculoSiniestro;
import com.example.hqlenvivo.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehiculoRepository;

    public Vehiculo save(Vehiculo v) {
        return vehiculoRepository.save(v);
    }
    public List<Vehiculo> findAll() {
        return vehiculoRepository.findAll();
    }
    public Optional<Vehiculo> findById(Long id) {
        return vehiculoRepository.findById(id);
    }

    public List<String> getAllPatentes() {
        return vehiculoRepository.findAllPatentes();
    }

    public List<Object[]> getPatenteMarcaOrdenAnio() {
        return vehiculoRepository.findPatenteMarcaOrderByAnio();
    }

    public List<String> getPatentesRuedasAnio(int anio) {
        return vehiculoRepository.findPatentesByRuedasAndAnio(anio);
    }

    public List<Object[]> getVehiculosPorSiniestroGrande(double monto) {
        return vehiculoRepository.findVehiculosBySiniestroMayorA(monto);
    }

    public List<VehiculoSiniestro> getVehiculoSiniestroConPerdida(double monto) {
        List<Object[]> res = vehiculoRepository.findVehiculoYPerdidaTotalBySiniestroMayorA(monto);
        List<VehiculoSiniestro> resultList = new ArrayList<>();
        for(Object[] row : res) {
            Vehiculo v = (Vehiculo) row[0];
            Double total = (Double) row[1];
            resultList.add(new VehiculoSiniestro(v,total));
        }
        return resultList;
    }
}

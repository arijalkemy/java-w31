package com.example.hqlenvivo.service;

import com.example.hqlenvivo.model.Siniestro;
import com.example.hqlenvivo.model.Vehiculo;
import com.example.hqlenvivo.repository.SinisterRepository;
import com.example.hqlenvivo.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SiniestroService {

    private final SinisterRepository siniestroRepository;
    private final VehicleRepository vehiculoRepository;

    public Siniestro save(Long vehiculoId, Siniestro siniestro) {
        Vehiculo v = vehiculoRepository.findById(vehiculoId)
                .orElseThrow(() -> new RuntimeException("Vehiculo no encontrado"));
        siniestro.setVehiculo(v);
        return siniestroRepository.save(siniestro);
    }

    public List<Siniestro> findAll() {
        return siniestroRepository.findAll();
    }
    public List<Siniestro> findByVehiculo(Long vehiculoId) {
        return siniestroRepository.findByVehiculoId(vehiculoId);
    }
}

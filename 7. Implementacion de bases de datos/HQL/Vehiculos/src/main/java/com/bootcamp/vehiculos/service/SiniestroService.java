package com.bootcamp.vehiculos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bootcamp.vehiculos.dtos.SiniestroDto;
import com.bootcamp.vehiculos.exception.BadRequestException;
import com.bootcamp.vehiculos.exception.NotFoundException;
import com.bootcamp.vehiculos.model.Siniestro;
import com.bootcamp.vehiculos.model.Vehicle;
import com.bootcamp.vehiculos.repository.SiniestroRepository;
import com.bootcamp.vehiculos.repository.VehiculoRepository;

@Service
public class SiniestroService implements ISiniestroService {
    private final SiniestroRepository siniestroRepository;
    private final VehiculoRepository vehicleRepository;

    public SiniestroService(SiniestroRepository siniestroRepository, VehiculoRepository vehicleRepository) {
        this.siniestroRepository = siniestroRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Long createSiniestro(SiniestroDto siniestroDto) {
        if (siniestroDto == null) {
            throw new BadRequestException("No se puede crear un siniestro nulo");
        }

        Siniestro siniestro = new Siniestro();
        siniestro.setFecha(siniestroDto.getFecha());
        siniestro.setPerdidaEconomica(siniestroDto.getPerdidaEconomica());

        if (siniestroDto.getVehiculoDenunciadoId() != null) {
            Vehicle vehiculo = vehicleRepository.findById(siniestroDto.getVehiculoDenunciadoId()).orElse(null);
            if (vehiculo == null) {
                throw new NotFoundException("No se encontró el vehículo asociado al siniestro");
            }
            siniestro.setVehiculoDenunciado(vehiculo);
        }

        Siniestro savedSiniestro = siniestroRepository.save(siniestro);
        return savedSiniestro.getId();
    }

    @Override
    public List<SiniestroDto> getAllSiniestros() {
        Iterable<Siniestro> siniestros = siniestroRepository.findAll();
        List<SiniestroDto> siniestroDtos = new ArrayList<>();

        for (Siniestro siniestro : siniestros) {
            siniestroDtos.add(SiniestroDto.fromEntity(siniestro));
        }
        if (siniestroDtos.isEmpty()) {
            throw new NotFoundException("No se encontraron siniestros");
        }

        return siniestroDtos;
    }

}

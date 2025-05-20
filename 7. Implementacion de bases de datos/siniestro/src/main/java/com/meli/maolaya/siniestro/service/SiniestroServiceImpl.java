package com.meli.maolaya.siniestro.service;

import org.springframework.stereotype.Service;

import com.meli.maolaya.siniestro.dto.SiniestroDto;
import com.meli.maolaya.siniestro.model.Siniestro;
import com.meli.maolaya.siniestro.repository.ISiniestroRepository;

@Service
public class SiniestroServiceImpl implements ISiniestroService {

    private ISiniestroRepository siniestroRepository;
    private IVehiculoService vehiculoService;

    public SiniestroServiceImpl(ISiniestroRepository siniestroRepository, IVehiculoService vehiculoService) {
        this.siniestroRepository = siniestroRepository;
        this.vehiculoService = vehiculoService;
    }

    @Override
    public void saveSiniestro(SiniestroDto siniestroDto) {
        Siniestro siniestro = Siniestro.builder()
                .fechaSiniestro(siniestroDto.getFechaSiniestro())
                .perdidaEconomica(siniestroDto.getPerdidaEconomica())
                .vehiculo(vehiculoService.findById(siniestroDto.getIdVehiculo())).build();
        siniestroRepository.save(siniestro);
    }

}

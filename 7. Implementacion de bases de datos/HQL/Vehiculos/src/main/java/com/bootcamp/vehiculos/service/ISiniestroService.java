package com.bootcamp.vehiculos.service;

import java.util.List;

import com.bootcamp.vehiculos.dtos.SiniestroDto;

public interface ISiniestroService {

    public Long createSiniestro(SiniestroDto siniestroDto);

    public List<SiniestroDto> getAllSiniestros();
}
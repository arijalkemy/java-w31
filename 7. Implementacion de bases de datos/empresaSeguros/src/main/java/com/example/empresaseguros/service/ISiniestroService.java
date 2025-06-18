package com.example.empresaseguros.service;

import com.example.empresaseguros.dto.SiniestroDto;

import java.util.List;

public interface ISiniestroService {
    List<SiniestroDto> obtenerSiniestros();
    SiniestroDto crearSiniestro(SiniestroDto siniestroDto);
    String borrarSiniestro(Long id);
    SiniestroDto modificarSiniestro(Long id, SiniestroDto newSiniestroDto);
}

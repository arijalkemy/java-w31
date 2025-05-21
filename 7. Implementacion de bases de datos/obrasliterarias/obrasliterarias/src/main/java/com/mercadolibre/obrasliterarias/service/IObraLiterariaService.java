package com.mercadolibre.obrasliterarias.service;

import com.mercadolibre.obrasliterarias.domain.ObraLiteraria;
import com.mercadolibre.obrasliterarias.dto.ObraLiterariaDto;

import java.util.List;

public interface IObraLiterariaService {
    void saveObra(ObraLiterariaDto obraLiterariaDto);
    List<ObraLiterariaDto> getObrasPorAutor(String autor);
    List<ObraLiterariaDto> buscarPorNombre(String nombre);
    List<ObraLiterariaDto> findTop5ByOrderByCantidadPaginasDesc();
    List<ObraLiterariaDto> findObraLiterariaPublicatedBeforeYear(Integer year);
    List<ObraLiterariaDto> buscarPorEditorial(String editorial);
}

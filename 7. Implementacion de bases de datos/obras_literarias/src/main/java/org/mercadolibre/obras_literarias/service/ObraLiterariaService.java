package org.mercadolibre.obras_literarias.service;

import org.mercadolibre.obras_literarias.dto.ObraLiterariaDTO;
import org.mercadolibre.obras_literarias.entity.ObraLiteraria;

import java.util.List;

public interface ObraLiterariaService {
    ObraLiterariaDTO createObraLiteraria(ObraLiterariaDTO obraLiterariaDTO);
    List<ObraLiterariaDTO> getAllObrasLiterarias();
    List<ObraLiterariaDTO> createMultipleObrasLiterarias(List<ObraLiterariaDTO> dtoList);
}

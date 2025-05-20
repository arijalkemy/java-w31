package org.mercadolibre.showroom.service;

import org.mercadolibre.showroom.dto.PrendaDTO;
import org.mercadolibre.showroom.entities.Prenda;

import java.util.List;

public interface PrendaService {

    List<PrendaDTO> massiveCreate(List<PrendaDTO> prendaDTOS);

    PrendaDTO createPrenda(PrendaDTO prendaDTO);

    List<PrendaDTO> getAllPrendas();

    PrendaDTO getPrendaByCode(String code);

    PrendaDTO updatePrendaByCode(String code, PrendaDTO prendaDTO);

    String deletePrenda(String code);

    List<PrendaDTO> getPrendaBySize(String size);

    List<PrendaDTO> getPrendaByName(String name);
}

package com.mercadolibre.joyeria.service;

import com.mercadolibre.joyeria.dto.JewelRequestDTO;
import com.mercadolibre.joyeria.dto.JewelResponseDTO;
import com.mercadolibre.joyeria.model.Jewel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IJewelService {

    List<JewelResponseDTO> getJewels();
    Long saveJewel(JewelRequestDTO jewel);
    JewelResponseDTO updateJewel(JewelRequestDTO jewel, Long id);
    void deleteJewel(Long id);
    JewelResponseDTO findJewelById(Long id);

}

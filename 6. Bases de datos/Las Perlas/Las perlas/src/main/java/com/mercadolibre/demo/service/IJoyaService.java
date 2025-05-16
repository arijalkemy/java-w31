package com.mercadolibre.demo.service;


import com.mercadolibre.demo.dto.JoyaDTO;
import com.mercadolibre.demo.model.Joya;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IJoyaService {

    Long newJewerly (JoyaDTO joya);

    List<JoyaDTO> getAllJewerly();

    void deleteJewerly(Long id);


    JoyaDTO updateJewerly(Long id, JoyaDTO joya);
}


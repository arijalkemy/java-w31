package com.example.joyerialasperlas.service;

import com.example.joyerialasperlas.dto.JoyaDTO;
import com.example.joyerialasperlas.model.Joya;

import java.util.List;

public interface IJoyaService {
    List<JoyaDTO> getJoyas();
    String saveJoya(JoyaDTO joya);
    List<JoyaDTO> deleteJoya(Long id);
    JoyaDTO findJoya(Long id);
    JoyaDTO modifyJoya(Long id, JoyaDTO joya);
}


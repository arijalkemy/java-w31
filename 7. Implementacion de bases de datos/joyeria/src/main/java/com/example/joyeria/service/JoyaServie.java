package com.example.joyeria.service;

import com.example.joyeria.DTO.JoyaDTO;

import java.util.List;

public interface JoyaServie {
    String createJoya(JoyaDTO joyaDTO);

    List<JoyaDTO> getJoyas();
    JoyaDTO getJoyaById(Long id);

    JoyaDTO updateJoya(Long id, JoyaDTO joyaDTO);

    String deleteJoya(Long id);

}

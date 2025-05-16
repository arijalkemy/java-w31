package com.bootcamp.joyerialasperlas.service;

import java.util.List;

import com.bootcamp.joyerialasperlas.dto.JoyaDto;

public interface IJoyaService {
    public List<JoyaDto> getJoyas();
    public Long saveJoya(JoyaDto joyaDto);
    public void deleteJoya(Long idJoya);
    public JoyaDto findJoya(Long idJoya);
    public JoyaDto updateJoya(Long idModificar, JoyaDto joyaDto);
}

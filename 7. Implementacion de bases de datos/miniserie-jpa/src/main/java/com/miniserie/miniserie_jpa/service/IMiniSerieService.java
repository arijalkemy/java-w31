package com.miniserie.miniserie_jpa.service;

import com.miniserie.miniserie_jpa.dto.MiniSerieDto;

import java.util.List;

public interface IMiniSerieService {
    public List<MiniSerieDto> getAll();
    public MiniSerieDto addMiniserie(MiniSerieDto miniSerieDto);
    public MiniSerieDto updateMiniSerie(Long id, MiniSerieDto miniSerieDto);
    public void deleteMiniSerie(Long id);
    public MiniSerieDto getMiniSerie(Long id);
}

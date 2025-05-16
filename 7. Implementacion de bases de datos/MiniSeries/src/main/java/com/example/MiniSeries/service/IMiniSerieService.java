package com.example.MiniSeries.service;

import com.example.MiniSeries.dto.MiniSerieDTO;
import com.example.MiniSeries.dto.UpdateMiniSerieDTO;
import com.example.MiniSeries.entity.MiniSerie;

import java.util.List;

public interface IMiniSerieService {
    List<MiniSerieDTO> getMiniSerie();
    void saveMiniSerie(MiniSerieDTO miniserie);
    void deleteMiniSerie(Long id);
    MiniSerieDTO findMiniSerie(Long id);
    String updateMiniSerie(Long id, UpdateMiniSerieDTO updateData);
}

package com.mercadolibre.testh2.service;

import com.mercadolibre.testh2.model.MiniSerie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMiniSerieService {
    public List<MiniSerie> getMiniSeries();
    public void saveMiniSerie(MiniSerie miniSerie);
    public void deleteMiniSerie(Long id);
    public MiniSerie find(Long id);
    public MiniSerie editMiniSerie(Long id, String name);
}

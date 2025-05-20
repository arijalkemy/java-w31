package com.mercadolibre.testh2.service;

import com.mercadolibre.testh2.model.MiniSerie;
import com.mercadolibre.testh2.repository.IMiniSerieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MiniSerieService implements IMiniSerieService {
    private final IMiniSerieRepository miniSerieRepository;

    public MiniSerieService(IMiniSerieRepository miniSerieRepository) {
        this.miniSerieRepository = miniSerieRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<MiniSerie> getMiniSeries() {
        return miniSerieRepository.findAll();
    }

    @Override
    @Transactional
    public void saveMiniSerie(MiniSerie miniSerie) {
        miniSerieRepository.save(miniSerie);
    }

    @Override
    @Transactional
    public void deleteMiniSerie(Long id) {
        miniSerieRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public MiniSerie find(Long id) {
        return miniSerieRepository.findById(id).orElse(null);
    }

    @Override
    public MiniSerie editMiniSerie(Long id, String name) {
        MiniSerie miniSerie = this.find(id);
        miniSerie.setName(name);
        return miniSerieRepository.save(miniSerie);
    }
}

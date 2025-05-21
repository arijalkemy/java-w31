package com.mercadolibre.demo.services;

import com.mercadolibre.demo.dto.MiniSerieDTO;
import com.mercadolibre.demo.model.MiniSerie;

import java.util.List;
import java.util.Optional;

public interface IMiniSerieService {
    public List<MiniSerieDTO> findAll();

    public Optional<MiniSerieDTO> findById(Long id);

    public void save(MiniSerieDTO miniSerie);

    public void delete(Long id);
}

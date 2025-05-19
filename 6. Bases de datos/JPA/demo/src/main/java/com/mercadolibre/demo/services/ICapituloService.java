package com.mercadolibre.demo.services;

import com.mercadolibre.demo.dto.CapituloDTO;

import java.util.List;
import java.util.Optional;

public interface ICapituloService {
    public List<CapituloDTO> findAll();
    public Optional<CapituloDTO> findById(Long id);
    public void save(Long id, CapituloDTO capitulo);
    public void delete(Long id);
}

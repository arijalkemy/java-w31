package com.example.elastic.service;

import com.example.elastic.dto.ArticuloDTO;
import java.util.List;

public interface ArticuloService {
    List<ArticuloDTO> findAll();
    ArticuloDTO findById(String id);
    ArticuloDTO save(ArticuloDTO articuloDTO);
    ArticuloDTO update(String id, ArticuloDTO articuloDTO);
    void delete(String id);
}
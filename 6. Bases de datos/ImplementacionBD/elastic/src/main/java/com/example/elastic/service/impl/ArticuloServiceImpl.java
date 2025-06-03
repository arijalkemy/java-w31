package com.example.elastic.service.impl;

import com.example.elastic.dto.ArticuloDTO;
import com.example.elastic.entities.Articulo;
import com.example.elastic.exception.ArticuloNotFoundException;
import com.example.elastic.repository.ArticuloRepository;
import com.example.elastic.service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    @Autowired
    private ArticuloRepository articuloRepository;

    @Override
    public List<ArticuloDTO> findAll() {
        return StreamSupport.stream(articuloRepository.findAll().spliterator(), false)
                .map(ArticuloDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ArticuloDTO findById(String id) {
        return articuloRepository.findById(id)
                .map(ArticuloDTO::fromEntity)
                .orElseThrow(() -> new ArticuloNotFoundException(id));
    }

    @Override
    public ArticuloDTO save(ArticuloDTO articuloDTO) {
        Articulo articulo = articuloDTO.toEntity();
        return ArticuloDTO.fromEntity(articuloRepository.save(articulo));
    }

    @Override
    public ArticuloDTO update(String id, ArticuloDTO articuloDTO) {
        if (!articuloRepository.existsById(id)) {
            throw new ArticuloNotFoundException(id);
        }
        Articulo articulo = articuloDTO.toEntity();
        articulo.setId(id);
        return ArticuloDTO.fromEntity(articuloRepository.save(articulo));
    }

    @Override
    public void delete(String id) {
        if (!articuloRepository.existsById(id)) {
            throw new ArticuloNotFoundException(id);
        }
        articuloRepository.deleteById(id);
    }
} 
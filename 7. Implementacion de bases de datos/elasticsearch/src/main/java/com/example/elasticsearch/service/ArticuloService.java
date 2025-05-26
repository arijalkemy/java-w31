package com.example.elasticsearch.service;

import com.example.elasticsearch.entity.Articulo;
import com.example.elasticsearch.repository.ArticuloRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticuloService {
    private final ArticuloRepository articuloRepository;

    public ArticuloService(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    public List<Articulo> findAllByTitulo(String titulo){
        return articuloRepository.findAllByTituloContainingIgnoreCase(titulo);
    }
}

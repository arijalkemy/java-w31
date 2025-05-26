package com.example.elasticsearch.controller;

import com.example.elasticsearch.entity.Articulo;
import com.example.elasticsearch.repository.ArticuloRepository;
import com.example.elasticsearch.service.ArticuloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticuloController {
    private final ArticuloService articuloService;

    public ArticuloController(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @GetMapping("/all")
    public List<Articulo> findAll(@RequestParam String title) {
        return articuloService.findAllByTitulo(title);
    }
}

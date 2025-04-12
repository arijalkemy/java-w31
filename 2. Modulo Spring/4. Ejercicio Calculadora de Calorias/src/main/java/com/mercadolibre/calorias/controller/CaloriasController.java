package com.mercadolibre.calorias.controller;

import com.mercadolibre.calorias.dto.PlatoDTO;
import com.mercadolibre.calorias.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/calorias")
public class CaloriasController {

    @Autowired
    private PlatoService platoService;

    @PostMapping("/plato")
    public PlatoDTO calcularCaloriasPlato(@RequestBody PlatoDTO platoDTO) {
        return platoService.calculateCalories(platoDTO.getNombrePlato(), platoDTO.getPeso());
    }

    @PostMapping("/platos")
    public List<PlatoDTO> calcularCaloriasPlatos(@RequestBody List<PlatoDTO> platosDTO) {
        return platoService.calculateCaloriesForMultipleDishes(platosDTO);
    }
}

package com.mercadolibre.testh2.controller;


import com.mercadolibre.testh2.model.MiniSerie;
import com.mercadolibre.testh2.service.IMiniSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MiniSerieController {

    @Autowired
    private IMiniSerieService miniSerieService;

    @PostMapping("/create")
    public String createMiniSerie(@RequestBody MiniSerie miniSerie) {
        miniSerieService.saveMiniSerie(miniSerie);
        return "Mini serie creada con exito";
    }

    @GetMapping("/")
    public List<MiniSerie> getMiniSeries() {
        return miniSerieService.getMiniSeries();
    }

    @PostMapping("/delete/{id}")
    public String deleteMiniSerie(@PathVariable Long id) {
        miniSerieService.deleteMiniSerie(id);
        return "Mini serie borrada con exito";
    }

    @PostMapping("/edit/{id}")
    public MiniSerie editMiniSerie(@PathVariable Long id, @RequestParam String name) {
        return miniSerieService.editMiniSerie(id, name);
    }
}

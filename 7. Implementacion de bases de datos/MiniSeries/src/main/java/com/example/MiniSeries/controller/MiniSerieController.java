package com.example.MiniSeries.controller;

import com.example.MiniSeries.dto.MiniSerieDTO;
import com.example.MiniSeries.dto.UpdateMiniSerieDTO;
import com.example.MiniSeries.service.MiniSerieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/mini_series")
public class MiniSerieController {

    @Autowired
    private MiniSerieServiceImpl service;

    @GetMapping
    public List<MiniSerieDTO> getMiniSeries() {
        return service.getMiniSerie();
    }

    @GetMapping("/{id}")
    public MiniSerieDTO getMiniSerieById(@PathVariable Long id){
        return service.findMiniSerie(id);
    }

    @PostMapping("/save_serie")
    public String saveMiniSerie(@RequestBody MiniSerieDTO miniSerieDTO) {
        service.saveMiniSerie(miniSerieDTO);
        return "MiniSerie guardada con éxito";
    }

    @DeleteMapping("/delete_serie/{id}")
    public String deleteMiniSerie(@PathVariable Long id){
        service.deleteMiniSerie(id);
        return "Se eliminó con éxito la mini serie";
    }

    @PostMapping("/edit/{id}")
    public String updateMiniSerie(@PathVariable Long id,
                                  @RequestBody UpdateMiniSerieDTO updateMiniSerieDTO) {
       return service.updateMiniSerie(id, updateMiniSerieDTO);
    }

}

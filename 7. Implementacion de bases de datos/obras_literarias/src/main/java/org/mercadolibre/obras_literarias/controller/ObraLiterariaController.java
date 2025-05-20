package org.mercadolibre.obras_literarias.controller;

import lombok.AllArgsConstructor;
import org.mercadolibre.obras_literarias.dto.ObraLiterariaDTO;
import org.mercadolibre.obras_literarias.service.ObraLiterariaServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/obras-literarias")
public class ObraLiterariaController {

    private ObraLiterariaServiceImpl service;

    @PostMapping("/create")
    public ObraLiterariaDTO create(@RequestBody ObraLiterariaDTO dto){
        return service.createObraLiteraria(dto);
    }

    @PostMapping("/massive-create")
    public List<ObraLiterariaDTO> massiveCreate(@RequestBody List<ObraLiterariaDTO> obraLiterariaDTOS) {
        return service.createMultipleObrasLiterarias(obraLiterariaDTOS);
    }

    @GetMapping
    public List<ObraLiterariaDTO> getAll(){
        return service.getAllObrasLiterarias();
    }
}

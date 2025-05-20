package org.mercadolibre.showroom.controller;

import lombok.Getter;
import org.mercadolibre.showroom.dto.PrendaDTO;
import org.mercadolibre.showroom.service.PrendaServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prendas")
public class PrendaController {

    final private PrendaServiceImpl service;

    public PrendaController(PrendaServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/create")
    public PrendaDTO createPrenda(@RequestBody PrendaDTO dto){
        return service.createPrenda(dto);
    }

    @PostMapping("/massive-create")
    public List<PrendaDTO> massiveCreatePrenda(@RequestBody List<PrendaDTO> dto){
        return service.massiveCreate(dto);
    }

    @GetMapping
    public List<PrendaDTO> getAllPrendas(){
        return service.getAllPrendas();
    }

    @GetMapping("/{code}")
    public PrendaDTO getPrendaByCode(@PathVariable String code){
        return service.getPrendaByCode(code);
    }

    @PutMapping("/{code}")
    public PrendaDTO updatePrenda(@PathVariable String code, @RequestBody PrendaDTO dto){
        return service.updatePrendaByCode(code, dto);
    }

    @GetMapping("/size/{size}")
    public List<PrendaDTO> getPrendaBySize(@PathVariable String size) {
        return service.getPrendaBySize(size);
    }

    @DeleteMapping("/delete/{code}")
    public String deletePrenda(@PathVariable String code) {
        return service.deletePrenda(code);
    }

    @GetMapping("/getByName")
    public List<PrendaDTO> getByName(@RequestParam String name){
        return service.getPrendaByName(name);
    }
}

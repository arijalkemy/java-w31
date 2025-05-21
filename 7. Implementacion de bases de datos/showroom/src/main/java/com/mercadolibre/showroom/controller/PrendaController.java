package com.mercadolibre.showroom.controller;

import com.mercadolibre.showroom.dto.request.PrendaRequestDto;
import com.mercadolibre.showroom.dto.response.PrendaResponseDto;
import com.mercadolibre.showroom.service.IPrendaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/clothes")
public class PrendaController {
    private final IPrendaService prendaService;

    @PostMapping("")
    public ResponseEntity<PrendaResponseDto> addPrenda(@RequestBody PrendaRequestDto prendaRequest){
        PrendaResponseDto prendaCreada = prendaService.addPrenda(prendaRequest);
        URI location = URI.create("" + prendaCreada.getId());
        return ResponseEntity.created(location).body(prendaCreada);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<PrendaResponseDto>> getAll(){
        return ResponseEntity.ok(prendaService.getAll());
    }

    @GetMapping("/get/{codigo}")
    public ResponseEntity<PrendaResponseDto> getByCodigo(@PathVariable String codigo){
        return ResponseEntity.ok(prendaService.getByCodigo(codigo));
    }

    @PutMapping("{codigo}")
    public ResponseEntity<PrendaResponseDto> updatePrenda(@PathVariable String codigo,
                                          @RequestBody PrendaRequestDto prendaRequest){
        return ResponseEntity.ok(prendaService.updatePrenda(codigo, prendaRequest));
    }

    @DeleteMapping("{codigo}")
    public ResponseEntity<?> deletePrenda(@PathVariable String codigo){
        prendaService.deleteByCodigo(codigo);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{talle}")
    public ResponseEntity<List<PrendaResponseDto>> getAllByTalle(@PathVariable String talle){
        return ResponseEntity.ok(prendaService.getAllByTalle(talle));
    }

    @GetMapping("/by-name")
    public ResponseEntity<List<PrendaResponseDto>> getByExistNombre(@RequestParam String nombre){
        return ResponseEntity.ok(prendaService.getByExistNombre(nombre));
    }

}

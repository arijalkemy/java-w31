package com.mercadolibre.showroom_uno.controller;

import com.mercadolibre.showroom_uno.dto.ClotheDto;
import com.mercadolibre.showroom_uno.service.IShowRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ShowRoomController {
    @Autowired
    IShowRoomService service;
    /* POST  /api/clothes Crear una nueva prenda.*/
    @PostMapping
    public ResponseEntity<Void> createClothe(@RequestBody ClotheDto clotheDto){
       service.createClothe(clotheDto);
       return ResponseEntity.noContent().build();
    }
    /* GET /api/clothes  Devolver todas las prendas*/
    @GetMapping
    public ResponseEntity<List<ClotheDto>> getAllClothes(){
      return new ResponseEntity<>(service.getAllClothes(), HttpStatus.OK);
    }

    /* GET /api/clothes/{code} Devolver una prenda en particular*/
    @GetMapping("/code/{code}")
    public ResponseEntity<ClotheDto> getClotheByCode(@PathVariable Long code){
        return new ResponseEntity<>(service.getClotheByCode(code), HttpStatus.OK);
    }
    /*PUT /api/clothes/{code} Actualizar una prenda en particular*/
    @PutMapping("/{code}")
    public ResponseEntity<Void> updeateClothe(@PathVariable Long code, @RequestBody ClotheDto clotheDto){
        service.updateClothe(code, clotheDto);
        return ResponseEntity.noContent().build();
    }

    /* DELETE /api/clothes/{code] Eliminar una prenda en particular*/
    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteClotheByCode(@PathVariable Long code){
        service.deleteClothe(code);
        return ResponseEntity.noContent().build();
    }
    /* GET /api/clothes/{size} Traer todas las prendas de un determinado talle*/
    @GetMapping("/size/{size}")
    public ResponseEntity<List<ClotheDto>> getClothesBySize(@PathVariable String size){
        return new ResponseEntity<>(service.getClothesBySize(size), HttpStatus.OK);
    }

    /* GET /api/clothes?name=remera Buscar todas las prendas en cuyo nombre aparezca
    la palabra “remera”. No se tienen en cuenta ni mayúsculas ni minúsculas*/
    @GetMapping("/search")
    public ResponseEntity<List<ClotheDto>> getClothesByName(@RequestParam String name){
        return new ResponseEntity<>(service.getClotheByName(name), HttpStatus.OK);
    }

}

package com.example.showroomrelacional.controller;

import com.example.showroomrelacional.entity.ClothDTO;
import com.example.showroomrelacional.entity.CreateClothRequest;
import com.example.showroomrelacional.service.ClothesService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
@AllArgsConstructor
public class ClothController {

    private ClothesService service;

    @PostMapping
    public ResponseEntity<ClothDTO> createNewCloth(@RequestBody CreateClothRequest newCloth) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createNewCloth(newCloth));
    }

    @GetMapping
    public ResponseEntity<List<ClothDTO>> getAllClothes() {
        return ResponseEntity.ok().body(service.getAllClothes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClothDTO> getClothByID(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.getClothById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClothDTO> updateClothByID(@PathVariable Long id, @RequestBody CreateClothRequest edited) {
        return ResponseEntity.ok().body(service.updateCloth(id, edited));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClothById(@PathVariable Long id) {
        service.deleteClothById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/by-size/{size}")
    public ResponseEntity<List<ClothDTO>> getClothesFromSize(@PathVariable String size) {
        return ResponseEntity.ok().body(service.getClothesBySize(size));
    }

    @GetMapping("/by-name")
    public ResponseEntity<List<ClothDTO>> getClothesByMatchingName(@RequestParam String query) {
        return ResponseEntity.ok().body(service.getClothesByMatchingName(query));
    }


}

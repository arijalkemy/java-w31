package com.consesionaria.consesionariavivo.controller;

import com.consesionaria.consesionariavivo.dto.AutoDTO;
import com.consesionaria.consesionariavivo.servicies.AutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class AutoRestController {
    private final AutoService autoService;

    @Autowired
    public AutoRestController(AutoService autoService) {
        this.autoService = autoService;
    }

    @PostMapping("/vehicles")
    public ResponseEntity<String> saveData(@RequestBody AutoDTO auto) {
        try {
            autoService.saveData(auto);
            return ResponseEntity.ok("Data saved successfully!");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error saving data");
        }
    }

}

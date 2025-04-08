package com.bootcamp.ejercicio_covid19.controller;

import com.bootcamp.ejercicio_covid19.dto.SymptomDto;
import com.bootcamp.ejercicio_covid19.service.ISymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SymptomController {
    @Autowired
    private ISymptomService symptomService;

    @GetMapping("/findSymptom")
    public ResponseEntity<List<SymptomDto>> getAll(){
        return ResponseEntity.ok(symptomService.getAll());
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<SymptomDto> getByName(@PathVariable String name){
        SymptomDto symptomDto = symptomService.findByName(name);
        if (symptomDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(symptomDto);
    }
}

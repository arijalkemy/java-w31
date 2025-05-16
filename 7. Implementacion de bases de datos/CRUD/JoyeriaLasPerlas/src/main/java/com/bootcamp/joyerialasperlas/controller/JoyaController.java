package com.bootcamp.joyerialasperlas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.bootcamp.joyerialasperlas.dto.JoyaDto;
import com.bootcamp.joyerialasperlas.service.IJoyaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/jewerly") 
public class JoyaController {
    @Autowired
    private IJoyaService service;

    @PostMapping("/new")
    public ResponseEntity<Long> createJoya(@Valid @RequestBody JoyaDto joya) {
        return new ResponseEntity<>(service.saveJoya(joya), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<JoyaDto>> getAllJoyas() {
        return new ResponseEntity<>(service.getJoyas(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJoya(@PathVariable Long id) {
        service.deleteJoya(id);
        return new ResponseEntity<>("Joya eliminada con éxito", HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<JoyaDto> getJoyaById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findJoya(id), HttpStatus.OK);
    }

    @PutMapping("/update/{idModificar}")
    public ResponseEntity<JoyaDto> updateJoya(@Valid @PathVariable Long idModificar, @RequestBody JoyaDto joyaDto) {
        return new ResponseEntity<>(service.updateJoya(idModificar, joyaDto), HttpStatus.OK);
    }
}

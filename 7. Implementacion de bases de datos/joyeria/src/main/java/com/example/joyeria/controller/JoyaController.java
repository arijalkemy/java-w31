package com.example.joyeria.controller;

import com.example.joyeria.DTO.JoyaDTO;
import com.example.joyeria.service.JoyaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class JoyaController {

    @Autowired
    private JoyaServiceImpl service;

    @PostMapping("/new")
    public String createJewel(@RequestBody JoyaDTO joyaDTO) {
        return service.createJoya(joyaDTO);
    }

    @GetMapping
    public List<JoyaDTO> getAllJewels() {
        return service.getJoyas();
    }

    @GetMapping("/{id}")
    public JoyaDTO getJewel(@PathVariable Long id) {
        return service.getJoyaById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteJewel(@PathVariable Long id){
        return service.deleteJoya(id);
    }

    @PutMapping("/update/{id_modificar}")
    public JoyaDTO updateJewel(@PathVariable Long id_modificar, @RequestBody JoyaDTO joyaDTO) {
        return  service.updateJoya(id_modificar, joyaDTO);
    }
}

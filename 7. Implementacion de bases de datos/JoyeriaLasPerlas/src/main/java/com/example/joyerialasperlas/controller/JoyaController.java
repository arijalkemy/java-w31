package com.example.joyerialasperlas.controller;

import com.example.joyerialasperlas.dto.JoyaDTO;
import com.example.joyerialasperlas.model.Joya;
import com.example.joyerialasperlas.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@Controller
@RequestMapping("/jewerly")
public class JoyaController {
    @Autowired
    private IJoyaService joyaService;

    @PostMapping("/new")
    public ResponseEntity<String> postJoya(@RequestBody JoyaDTO joyaDTO){
        return new ResponseEntity<>(joyaService.saveJoya(joyaDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<JoyaDTO>> getJoyas(){
        return ResponseEntity.ok(joyaService.getJoyas());
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<JoyaDTO> editStudent (@PathVariable Long id,
                                @RequestBody JoyaDTO newJoya) {
        return  ResponseEntity.ok(joyaService.modifyJoya(id, newJoya));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<JoyaDTO>> deleteJoya (@PathVariable Long id) {
        return ResponseEntity.ok(joyaService.deleteJoya(id));
    }
}

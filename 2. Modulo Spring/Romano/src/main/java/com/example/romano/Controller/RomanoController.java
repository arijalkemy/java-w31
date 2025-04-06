package com.example.romano.Controller;

import com.example.romano.Services.RomanoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanoController {

    private final RomanoService romanoService;

    public RomanoController(RomanoService romanoService) {
        this.romanoService = romanoService;
    }

    @GetMapping("/romano/{numero}")
    public String convertir(@PathVariable int numero) {
        return romanoService.convertirARomano(numero);
    }
}
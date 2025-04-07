package com.alkemy.wave31.Controllers;


import com.alkemy.wave31.RomanosModelo.ConvertirRomanos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EjercicioController {

    public final ConvertirRomanos romano;

    public EjercicioController(ConvertirRomanos romano) {
        this.romano = romano;
    }

    @GetMapping("/ConvertirRomano")
    public int ConvertirRomano(@RequestParam String numeroRomano) {
        return romano.ConvertirRomanos(numeroRomano);
    }
}

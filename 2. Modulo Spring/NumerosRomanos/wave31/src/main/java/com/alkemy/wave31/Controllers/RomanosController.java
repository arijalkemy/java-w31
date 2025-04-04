package com.alkemy.wave31.Controllers;

import com.alkemy.wave31.Models.ConvertirRomanos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanosController {
    public final ConvertirRomanos romanos;
    @Autowired
    public RomanosController(ConvertirRomanos convertirRomanos) {
        this.romanos = convertirRomanos;
    }

    @GetMapping("/convertir-romano")
    public int getRomanos(@RequestParam String romano) {
        return romanos.convertirNumero(romano);
    }
}

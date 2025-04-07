package com.edad.dto_edad.Controller;

import com.edad.dto_edad.Service.CalculadoraEdad;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {

    @GetMapping("/{dia}/{mes}/{year}")
    public Integer getEdad(@PathVariable Integer dia,
                           @PathVariable Integer mes,
                           @PathVariable Integer year) {
        return CalculadoraEdad.calcularEdad(dia, mes, year);
    }
}

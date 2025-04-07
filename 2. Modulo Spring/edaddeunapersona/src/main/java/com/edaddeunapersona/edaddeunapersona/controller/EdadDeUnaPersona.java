package com.edaddeunapersona.edaddeunapersona.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

@RestController
public class EdadDeUnaPersona {

    @GetMapping(path = "{dia}/{mes}/{anio}")
    public ResponseEntity<?> consultarEdad(@PathVariable Integer dia,
                                                 @PathVariable Integer mes,
                                                 @PathVariable Integer anio
    ){
        //Fecha actual
        LocalDate fechaHoy = LocalDate.now();

        //Fecha recibida
        LocalDate fechaRecibida = LocalDate.of(anio,mes,dia);

        //Chequeo que la fecha no sea futura
        if (fechaRecibida.isAfter(fechaHoy)) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(Map.of("Error", "La fecha de nacimiento no puede ser en el futuro"));
        }

        //Cálcula la diferencia
        Period edad = Period.between(fechaRecibida,fechaHoy);

        return ResponseEntity.ok(edad.getYears());
    }

}

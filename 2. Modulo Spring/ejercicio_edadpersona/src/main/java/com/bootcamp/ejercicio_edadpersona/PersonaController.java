package com.bootcamp.ejercicio_edadpersona;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Period;

@RestController
public class PersonaController {


    @GetMapping("{dia}/{mes}/{anio}")
    public ResponseEntity<?> getPersonAge(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio) {
        try{
            LocalDate localDate = LocalDate.now();
            LocalDate requestDate  = LocalDate.of(anio, mes, dia);
            if(requestDate.isAfter(localDate)){
                throw new Exception("La fecha introducida es mayor a la fecha actual");
            }
            return new ResponseEntity<>(Period.between(requestDate, localDate).getYears(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

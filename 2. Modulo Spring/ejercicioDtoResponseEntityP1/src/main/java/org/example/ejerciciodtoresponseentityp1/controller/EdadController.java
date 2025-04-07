package org.example.ejerciciodtoresponseentityp1.controller;

import org.example.ejerciciodtoresponseentityp1.models.entity.ResponseEdad;
import org.example.ejerciciodtoresponseentityp1.service.EdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpResponse;


@RestController
public class EdadController {

    final String formatoFecha="yyyy-MM-dd";


    @Autowired
    EdadService edadService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public ResponseEntity<String> obtenerEdad(@PathVariable String dia, @PathVariable String mes, @PathVariable String anio) {
        ResponseEdad responseEdad = new ResponseEdad();

        if(edadService.sonCorrectosLosDigitos(dia,mes,anio)){
            try {
                String fechaNacimiento = anio + "-" + mes + "-" + dia;
                if (edadService.isValidDate(fechaNacimiento, formatoFecha)) {
                    edadService.calcularEdad(fechaNacimiento, responseEdad);
                } else {
                    responseEdad.setError("La fecha que se ingresó está incorrecta.");
                    throw new Exception("La fecha que se ingresó está incorrecta.");
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }else{
            responseEdad.setError("Los digitos ingresados no son los correctos.");
        }

        return new ResponseEntity<>(responseEdad.toString(),HttpStatus.OK);
    }

}

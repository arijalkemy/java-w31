package com.example.EdadPersona.Controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.EdadPersona.Service.EdadPersonaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/*
 * Se necesita desarrollar un API que recibe como parámetro tres valores:
 *  - Día
 *  - Mes
 *  - Año
 * 
 * Dichos valores corresponden a la fecha de nacimiento de una persona y deben ser valores
 * enteros. Por ejemplo, un ingreso válido sería: 10/01/1990.
 * Para este caso, es necesario que la fecha de nacimiento se pase mediante la URL del
 * navegador. Por ejemplo: http://localhost:8080/10/01/1990. Como resultado, la API deberá
 * devolver la edad de la persona.
 * En el navegador se debería ver algo similar:
 */
@RestController
public class EdadPersonaController {
    @Autowired
    EdadPersonaService edadPersonaService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public String getEdadPersona(@PathVariable Integer dia, @PathVariable Integer mes, @PathVariable Integer anio) {
        return edadPersonaService.calcularEdad(dia, mes, anio);
    }

}

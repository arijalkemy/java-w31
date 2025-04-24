package com.fernandotorres.dtoyresponseentity.controller;

import com.fernandotorres.dtoyresponseentity.model.ConversorEdad;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {

    @GetMapping("/fechanacimiento/{dia}/{mes}/{anio}")
    public Integer fechaNacimiento(@PathVariable Integer dia,
                                  @PathVariable Integer mes,
                                  @PathVariable Integer anio) {
        return ConversorEdad.convertirFecha(dia,mes,anio);
    }
}


/*Se necesita desarrollar un API que recibe como parámetro tres valores:


@GetMapping("/{dia}/{mes}/{anio}")
    public ResponseEntity<String> getEdad(@PathVariable String dia, @PathVariable String mes, @PathVariable String anio) {

        try {
            Integer diaInt = Integer.parseInt(dia);
            Integer mesInt = Integer.parseInt(mes);
            Integer anioInt = Integer.parseInt(anio);

            LocalDate fecha = LocalDate.of(anioInt, mesInt, diaInt);
            LocalDate hoy = LocalDate.now();

            Period periodo = Period.between(fecha, ho
Period periodo = Period.between(fecha, hoy);
            Integer edad = periodo.getYears();

            return ResponseEntity.ok(String.valueOf(edad));
        } catch (NumberFormatException | DateTimeException e) {
            return new ResponseEntity<>("Valores incorrectos para fecha de nacimiento.", HttpStatus.BAD_REQUEST);
        }
    }
Día
Mes
Año

Dichos valores corresponden a la fecha de nacimiento de una persona y deben ser valores enteros. Por ejemplo, un ingreso válido sería: 10/01/1990.

Para este caso, es necesario que la fecha de nacimiento se pase mediante la URL del navegador. Por ejemplo: http://localhost:8080/10/01/1990. Como resultado, la API deberá devolver la edad de la persona.

En el navegador se debería ver algo similar:




Realizar los pasos necesarios para implementar un método en el controlador que mapee correctamente el path ingresado y que devuelva la información requerida.

*/
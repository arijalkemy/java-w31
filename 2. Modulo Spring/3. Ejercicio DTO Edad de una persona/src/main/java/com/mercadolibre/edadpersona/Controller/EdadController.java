package com.mercadolibre.edadpersona.Controller;

import com.mercadolibre.edadpersona.Model.EjercicioEdad;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadController {

    private final EjercicioEdad ejercicioEdad;

    public EdadController(EjercicioEdad ejercicioEdad) {
        this.ejercicioEdad = ejercicioEdad;
    }

    @GetMapping(path = "/{dia}/{mes}/{anio}")
    public int getEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {
        return ejercicioEdad.calcularEdad(dia, mes, anio);
    }
}

/* *
 try {
            Integer edad = edadService.calcularEdad(dia, mes, anio);
            return new ResponseEntity<>(edad, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST); // En caso de error, devuelve 400
        } catch (Exception e) {
            return new ResponseEntity<>("Ocurrió un error inesperado", HttpStatus.INTERNAL_SERVER_ERROR); // Error inesperado
        }
@GetMapping("/{dia}/{mes}/{anio}")
    public ResponseEntity<Object> obtenerEdad(@PathVariable int dia, @PathVariable int mes, @PathVariable int anio) {

    }
* */

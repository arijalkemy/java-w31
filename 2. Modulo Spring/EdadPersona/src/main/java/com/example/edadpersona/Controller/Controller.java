package com.example.edadpersona.Controller;
import com.example.edadpersona.Services.EdadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class Controller {
    @Autowired
    private EdadService edadService;

    @GetMapping("/{dia}/{mes}/{anio}")
    public String obtenerEdad(@PathVariable int dia,
                              @PathVariable int mes,
                              @PathVariable int anio) {
        if (mes < 1 || mes > 12) {
            return "Mes inválido.";
        }

        if (dia < 1 || dia > diasDelMes(mes, anio)) {
            return "Día inválido para el mes ingresado.";
        }


        int edad = edadService.calcularEdad(dia, mes, anio);
        return "La persona tiene " + edad + " años.";
    }
    private int diasDelMes(int mes, int anio) {
        switch (mes) {
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return esBisiesto(anio) ? 29 : 28;
            default:
                return 31;
        }

    }

    private boolean esBisiesto(int anio) {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
    }
}
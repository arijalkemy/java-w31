package com.edaddeunapersona.edaddeunapersona.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EdadDeUnaPersona {

    @GetMapping(path = "{dia}/{mes}/{anio}")
    public Integer consultarEdad(@PathVariable Integer dia,
                                 @PathVariable Integer mes,
                                 @PathVariable Integer anio
    ){
        //Supongo que se valida que los datos ingresados esten un rango valido
        //Fecha hoy
        Integer diaActual = 7,mesActual = 4,anioActual = 2025, resultado = 0;

        //Calculo por año
        resultado = anioActual - anio;

        //Chequeo por mes
        if(mesActual <mes){
            resultado --;
        }else if(mesActual.equals(mes)){
            //Chequedo día
            if(diaActual<dia){
                resultado--;
            }
        }
        return resultado;
    }
}

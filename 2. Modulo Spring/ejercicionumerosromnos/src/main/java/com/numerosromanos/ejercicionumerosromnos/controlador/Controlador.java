package com.numerosromanos.ejercicionumerosromnos.controlador;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class Controlador {

    @GetMapping("{numero}")
    public String convertir(@PathVariable Integer numero){
        return this.consultar(numero);
    }

    private String consultar(Integer i)
    {
        //Voy a crear un diccionario
        HashMap<Integer,String> numeros = new HashMap<>();
        numeros.put(1,"I");
        numeros.put(2,"II");
        numeros.put(3,"III");
        numeros.put(4,"IV");
        numeros.put(5,"V");
        numeros.put(7,"VII");
        numeros.put(10,"X");
        numeros.put(13,"XIII");
        numeros.put(50,"L");
        numeros.put(100,"C");
        numeros.put(500,"D");
        numeros.put(1000,"M");

        if(numeros.containsKey(i)){
            return numeros.get(i);
        }
        else{
            return "Error en la conversión";
        }
    }

}

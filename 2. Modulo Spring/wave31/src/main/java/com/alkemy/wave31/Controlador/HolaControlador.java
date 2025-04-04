package com.alkemy.wave31.Controlador;

import org.springframework.web.bind.annotation.*;

@RestController
public class HolaControlador {

    @GetMapping("prueba/{nombre}")
    public String getPrueba(
            @PathVariable String nombre,
            @RequestParam(required = false) String parametro1,
            @RequestParam(required = false) String parametro2
    ){
        //Aqui estoy utilizando Lombok
        PruebaLombok p = new PruebaLombok();
        p.getNombre();

        return "Hola " + nombre + "\nSoy el primer parametro: "+ parametro1 + "\nSoy el segundo paramentro: "+parametro2;
    }

    @PostMapping("prueba")
    public String postPrueba(){
        return "Hola prueba";
    }

    @PutMapping("prueba")
    public String putPrueba(){
        return "Hola prueba";
    }

    @DeleteMapping("prueba")
    public String deletePrueba(){
        return "Hola prueba";
    }

}

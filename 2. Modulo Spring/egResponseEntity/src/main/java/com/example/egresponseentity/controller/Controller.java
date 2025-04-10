package com.example.egresponseentity.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class Controller {

    @GetMapping("/hola")
    ResponseEntity<String> hola() {
        // Junto al string devolves un codigo de respuesta
        return new ResponseEntity<>("Hola mundo desde una rta http", HttpStatus.OK);
    }

    // podemos hacer validaciones y devolver codigos de satuts segun corresponda
    @GetMapping("/verificar/{correo}")
    ResponseEntity<String> verificarCorreo(@PathVariable String correo){
        // obviamente deberia crear el validador, es un ejemplo
        if(EmailValidator.getInstance().isValid(correo)){
            return new ResponseEntity<>("Formato debe ser: eg@dominio", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Su correo es: " + correo, HttpStatus.OK);
    }

    //podemos crear le header del cliente
    @GetMapping("/cabecera/{cliente}")
    ResponseEntity<String> cabeceraPersonalizada(@PathVariable String cliente){
        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add("Estado ciente", "cliente " + cliente + ": habilitdo");

        return new ResponseEntity<>("Bienvenido " + cliente, cabecera, HttpStatus.OK);
    }

    // Response entitty tambien posee metodos para hacer lo que hicimos arriba pero ams sencillo

    @GetMapping("/hola")
    ResponseEntity<String> hola2() {
        // Junto al string devolves un codigo de respuesta
        return ResponseEntity.ok("Hola mundo desde una rta http");
    }

    @GetMapping("/verificar/{correo}")
    ResponseEntity<String> verificarCorreo2(@PathVariable String correo){
        // obviamente deberia crear el validador, es un ejemplo
        if(EmailValidator.getInstance().isValid(correo)){
            return ResponseEntity.badRequest().body("Formato debe ser: eg@dominio");
        }
        return ResponseEntity.status(200).body("Su correo es: " + correo);
    }

}

package com.linktracker.link.controller;

import com.linktracker.link.dto.LinkRequestDTO;
import com.linktracker.link.dto.LinkResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinkController {

    /*
    Crear un link: Endpoint POST para crear link a partir de una URL válida
    y tiene que devolver un JSON con el linkId para utilizar en la redirección.
     */

    @PostMapping
    public ResponseEntity<LinkResponseDTO> postLink(@RequestBody LinkRequestDTO body) {
        return new ResponseEntity<>(new LinkResponseDTO(), HttpStatus.CREATED);
    }
}

package com.miprimerproyecto.pruebaspring.controller;

import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miprimerproyecto.pruebaspring.dto.DecodedMessageDto;
import com.miprimerproyecto.pruebaspring.service.MorseService;

@RestController
public class MorseController {

    MorseService morseService;

    public MorseController(MorseService morseService){
        this.morseService = morseService;
    }

    @PostMapping("/morse/message")
    public ResponseEntity<DecodedMessageDto> getDecodedMessage(
        @RequestBody HashMap<String, String> body
    ){
        String message = body.get("message");
        return new ResponseEntity<>(this.morseService.getDecodedMessage(message), HttpStatus.OK);
    }
}

package com.bootcamp.springp2vivomorse.controller;

import com.bootcamp.springp2vivomorse.dto.DecryptRequestBody;
import com.bootcamp.springp2vivomorse.service.MorseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {
    private MorseService morseService;

    public MorseController(MorseService morseService) {
        this.morseService = morseService;
    }

    @PostMapping("/decrypt")
    public String decrypt(@RequestBody DecryptRequestBody req){
        return morseService.decrypt(req);
    }

}

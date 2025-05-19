package com.example.codigo_morse.controller;

import com.example.codigo_morse.service.CodeMorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/codeMorse")
public class CodeMorseController {

    @Autowired
    CodeMorseService codeMorseService;

    @PostMapping("/translate")
    public String translateMorseToText(@RequestBody String codeMorse){
        return codeMorseService.translateMorseToText(codeMorse);
    }
}

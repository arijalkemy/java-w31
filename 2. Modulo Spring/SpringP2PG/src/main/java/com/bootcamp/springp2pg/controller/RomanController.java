package com.bootcamp.springp2pg.controller;

import com.bootcamp.springp2pg.service.RomanService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanController {
    RomanService romanService;


    public RomanController(){
        romanService = new RomanService();
    }
    @GetMapping("/{param}")
    public String decimalToRoman(@PathVariable Integer param){
        return romanService.toRoman(param);
        };
    }


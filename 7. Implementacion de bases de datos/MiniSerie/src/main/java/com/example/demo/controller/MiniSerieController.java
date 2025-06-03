package com.example.demo.controller;

import com.example.demo.service.MiniSerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MiniSerieController {
    @Autowired
    MiniSerieService miniSerieService;
    @GetMapping("/")
    public void  save(){
        miniSerieService.save();
    }
}

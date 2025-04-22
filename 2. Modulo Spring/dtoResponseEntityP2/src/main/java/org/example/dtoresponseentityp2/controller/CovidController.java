package org.example.dtoresponseentityp2.controller;

import org.example.dtoresponseentityp2.model.entity.BdInMemory;
import org.example.dtoresponseentityp2.service.CovidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CovidController {

    @Autowired
    CovidService covidService;

    @GetMapping("/findSymptom")
    public void getSymptom(){
        BdInMemory bdInMemory= covidService.cargarDatos();


    }

    @GetMapping("/findSymptom/{name}")
    public void getSymptomByName(@PathVariable String name){

    }

    @GetMapping("/findRiskPerson")
    public void findRiskPerson(){

    }




}

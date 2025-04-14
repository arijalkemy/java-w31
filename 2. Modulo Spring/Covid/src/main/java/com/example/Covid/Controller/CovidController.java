package com.example.Covid.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.Covid.Entities.RiskPersonDTO;
import com.example.Covid.Entities.Symptom;
import com.example.Covid.Service.CovidService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/")
public class CovidController {
    @Autowired
    private CovidService covidService;

    @GetMapping("/findSymptom")
    @ResponseBody
    public List<Symptom> getMethodName() {
        return covidService.getSymptoms();
    }

    @GetMapping("/findSymptom/{name}")
    public ResponseEntity<String> getSymptomGravityByName(@PathVariable String name) {
        Symptom symptom = covidService.getSymptomByName(name);
        if (symptom != null) {
            return new ResponseEntity<>(
                    "El síntoma " + symptom.getName() + " tiene un nivel de gravedad " + symptom.getGravityLevel(),
                    HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Síntoma no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/findRiskPerson")
    public List<RiskPersonDTO> findRiskPerson() {
        return covidService.getRiskPersons();
    }
}

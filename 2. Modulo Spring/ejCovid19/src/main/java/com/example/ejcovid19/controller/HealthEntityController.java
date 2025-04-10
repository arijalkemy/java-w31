package com.example.ejcovid19.controller;

import com.example.ejcovid19.DTO.PacientDTO;
import com.example.ejcovid19.repository.HealthEntityDb;
import com.example.ejcovid19.service.Person;
import com.example.ejcovid19.service.Symptom;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HealthEntityController {
    private final HealthEntityDb repository = new HealthEntityDb();

    @GetMapping(path = "/findSymptom")
    @ResponseBody
    public List<Symptom> getAllSymptoms(){
        return repository.getSymptoms();
    }

    @GetMapping(path = "/findSymptom/{name}")
    ResponseEntity<String> getSymptomByName(@PathVariable String name){
        if (repository.levelOfSymptom(name) == "Not found"){
            return ResponseEntity.badRequest().body("Symptom not found");
        }
        return ResponseEntity.ok(repository.levelOfSymptom(name));
    }

    @GetMapping(path = "/findRiskPerson")
    @ResponseBody
    public List<PacientDTO> getRiskPacients(){
        List<Symptom> symtoms = repository.getSymptoms();
        List<Person> pacients = repository.getPacients();
        List<PacientDTO> pacientDTOList = new ArrayList<>();

        int symptomPos = 0;
        for(Person pacient : pacients){
            if (pacient.getAge() > 60) {
                String fullName = pacient.getName() + " " + pacient.getLastname();
                pacientDTOList.add(new PacientDTO(fullName, pacient.getAge(), symtoms.get(symptomPos).getName()));
                symptomPos++;
                if (symptomPos == 3) {
                    symptomPos = 0;
                }
            }
        }

        return pacientDTOList;

    }
}

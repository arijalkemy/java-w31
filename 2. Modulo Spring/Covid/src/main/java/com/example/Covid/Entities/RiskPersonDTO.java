package com.example.Covid.Entities;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RiskPersonDTO implements Serializable {
    String name;
    String lastName;
    List<Symptom> symptoms;

    public RiskPersonDTO(String name, String lastName, List<Symptom> symptoms) {
        this.name = name;
        this.lastName = lastName;
        this.symptoms = symptoms;
    }

    public void addSymptom(Symptom symptom) {
        this.symptoms.add(symptom);
    }

    public void removeSymptom(Symptom symptom) {
        this.symptoms.remove(symptom);
    }
}

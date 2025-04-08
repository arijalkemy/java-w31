package com.bootcamp.ejerciciocovid19.repository;

import com.bootcamp.ejerciciocovid19.entity.Symptom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SymptomRepository implements ISymptomRepository{
    List<Symptom> symptoms;

    public SymptomRepository(){
        this.symptoms = new ArrayList<>();
        symptoms.add(new Symptom("T", "Tos", "Leve"));
        symptoms.add(new Symptom("F", "Fiebre", "Grave"));
        symptoms.add(new Symptom("N", "Nauseas", "Grave"));
        symptoms.add(new Symptom("O", "Falta de olfato", "Medio"));
        symptoms.add(new Symptom("G", "Falta de gusto", "Medio"));
        symptoms.add(new Symptom("D", "Dolor muscular", "Medio"));
    }
    @Override
    public List<Symptom> allSymptoms() {
        return symptoms;
    }

    @Override
    public Optional<Symptom> findSymptom(String name) {
        return symptoms.stream().filter(s -> s.getNombre().equals(name)).findFirst();
    }
}

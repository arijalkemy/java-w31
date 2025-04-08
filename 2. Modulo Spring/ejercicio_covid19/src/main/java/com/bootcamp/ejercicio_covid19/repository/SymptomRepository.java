package com.bootcamp.ejercicio_covid19.repository;

import com.bootcamp.ejercicio_covid19.model.Symptom;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SymptomRepository implements ISymptomRepository {
    private final List<Symptom> symptoms;

    public SymptomRepository() {
        this.symptoms = new ArrayList<>();
    }

    @Override
    public List<Symptom> getAll() {
        return this.symptoms;
    }

    @Override
    public void save(Symptom symptom) {
        this.symptoms.add(symptom);
    }

    @Override
    public void saveAll(List<Symptom> symptoms) {
        this.symptoms.addAll(symptoms);
    }

    @Override
    public Symptom findByName(String name) {
        return symptoms.stream().filter(symptom -> symptom.getName().equals(name)).findFirst().orElse(null);
    }
}

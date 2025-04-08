package com.bootcamp.ejercicio_covid19.repository;

import com.bootcamp.ejercicio_covid19.model.Symptom;

import java.util.List;

public interface ISymptomRepository {
    List<Symptom> getAll();
    void save(Symptom symptom);
    void saveAll(List<Symptom> symptoms);
    Symptom findByName(String name);
}

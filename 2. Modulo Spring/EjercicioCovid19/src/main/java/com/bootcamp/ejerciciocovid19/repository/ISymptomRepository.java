package com.bootcamp.ejerciciocovid19.repository;

import com.bootcamp.ejerciciocovid19.entity.Symptom;

import java.util.List;
import java.util.Optional;

public interface ISymptomRepository {
    public List<Symptom> allSymptoms();

    Optional<Symptom> findSymptom(String name);
}

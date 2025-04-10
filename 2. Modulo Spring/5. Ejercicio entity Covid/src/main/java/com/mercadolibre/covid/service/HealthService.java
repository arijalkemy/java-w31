package com.mercadolibre.covid.service;

import com.mercadolibre.covid.dto.RiskPersonDTO;
import com.mercadolibre.covid.model.Symptom;
import com.mercadolibre.covid.repository.HealthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HealthService {

    @Autowired
    private HealthRepository healthRepository;

    public List<Symptom> getAllSymptoms() {
        return healthRepository.getSymptoms();
    }

    public Symptom getSymptomByName(String name) {
        return healthRepository.findSymptomByName(name);
    }

    public List<RiskPersonDTO> getRiskPersons() {
        return healthRepository.getPersons().stream()
                .filter(person -> person.getAge() > 60 && !person.getSymptoms().isEmpty())
                .map(person -> new RiskPersonDTO(person.getName(), person.getSurname()))
                .collect(Collectors.toList());
    }
}

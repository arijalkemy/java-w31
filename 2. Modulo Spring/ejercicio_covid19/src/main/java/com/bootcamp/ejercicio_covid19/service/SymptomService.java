package com.bootcamp.ejercicio_covid19.service;

import com.bootcamp.ejercicio_covid19.dto.SymptomDto;
import com.bootcamp.ejercicio_covid19.model.Symptom;
import com.bootcamp.ejercicio_covid19.repository.ISymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomService implements ISymptomService {
    private final ISymptomRepository symptomRepository;

    @Autowired
    public SymptomService(ISymptomRepository symptomRepository) {
        this.symptomRepository = symptomRepository;
        loadSymptoms();
    }

    private void loadSymptoms() {
        symptomRepository.saveAll(List.of(
                new Symptom("SYM1", "Fiebre", "Moderado"),
                new Symptom("SYM2", "Tos seca", "Leve"),
                new Symptom("SYM3", "Dificultad para respirar", "Alto"),
                new Symptom("SYM4", "Fatiga", "Moderado"),
                new Symptom("SYM5", "Dolor de cabeza", "Leve"),
                new Symptom("SYM6", "Dolor de garganta", "Leve"),
                new Symptom("SYM7", "Pérdida del gusto", "Moderado"),
                new Symptom("SYM8", "Pérdida del olfato", "Moderado"),
                new Symptom("SYM9", "Dolor muscular", "Moderado"),
                new Symptom("SYM10", "Escalofríos", "Leve"),
                new Symptom("SYM11", "Congestión nasal", "Leve"),
                new Symptom("SYM12", "Náuseas", "Moderado"),
                new Symptom("SYM13", "Vómitos", "Alto"),
                new Symptom("SYM14", "Diarrea", "Moderado"),
                new Symptom("SYM15", "Erupciones cutáneas", "Moderado"),
                new Symptom("SYM16", "Dolor abdominal", "Moderado"),
                new Symptom("SYM17", "Dificultad para concentrarse", "Leve"),
                new Symptom("SYM18", "Confusión", "Alto"),
                new Symptom("SYM19", "Insomnio", "Leve"),
                new Symptom("SYM20", "Sibilancias", "Alto")
        ));
    }

    @Override
    public List<SymptomDto> getAll() {
        return symptomRepository.getAll().stream()
                .map(s -> new SymptomDto(s.getCode(), s.getName(), s.getSeverityLevel()))
                .toList();
    }

    @Override
    public SymptomDto findByName(String name) {
        Symptom symptom = symptomRepository.findByName(name);
        return symptom == null ? null : new SymptomDto(symptom.getCode(), symptom.getName(), symptom.getSeverityLevel());
    }
}

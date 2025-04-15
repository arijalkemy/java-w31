package co.com.mercadolibre.diecinueve.coviddiecinueve.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import co.com.mercadolibre.diecinueve.coviddiecinueve.domain.Symptom;
import co.com.mercadolibre.diecinueve.coviddiecinueve.dto.SymptomDto;
import co.com.mercadolibre.diecinueve.coviddiecinueve.enums.Severity;

@Service
public class SymptomServiceImpl implements SymptomService{

    List<Symptom> symptomsList = new ArrayList<>();

    @Override
    public List<SymptomDto> findAllSymptoms() {
        Symptom firstSymptom = new Symptom("313132", "Cough", Severity.MILD);
        Symptom secondSymptom = new Symptom("212121", "Diarrhea", Severity.CRITICAL);
        Symptom thirdSymptom = new Symptom("111122", "Headache", Severity.SEVERE);
        symptomsList.add(firstSymptom);
        symptomsList.add(secondSymptom);
        symptomsList.add(thirdSymptom);
        return symptomsList.stream()
        .map(s -> new SymptomDto(s.getCode(), s.getName(), s.getSeverity()))
        .collect(Collectors.toList());
    }

    @Override
    public SymptomDto findSypmtomSeverityByName(String name) {
        return symptomsList.stream()
        .filter(s -> s.getName().equals(name))
        .findFirst()
        .map(s -> new SymptomDto(s.getCode(), s.getName(), s.getSeverity()))
        .get();
    }
    
}

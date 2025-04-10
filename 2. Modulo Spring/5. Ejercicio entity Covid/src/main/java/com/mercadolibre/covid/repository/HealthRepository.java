package com.mercadolibre.covid.repository;

import com.mercadolibre.covid.model.Person;
import com.mercadolibre.covid.model.Symptom;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
public class HealthRepository {
    private final List<Symptom> symptoms = new ArrayList<>();
    private final List<Person> persons = new ArrayList<>();

    public HealthRepository() {
        Symptom fever = new Symptom("S001", "Fever", "Medium");
        Symptom cough = new Symptom("S002", "Cough", "Low");
        Symptom breathlessness = new Symptom("S003", "Breathlessness", "High");

        symptoms.add(fever);
        symptoms.add(cough);
        symptoms.add(breathlessness);

        persons.add(new Person("1", "John", "Doe", 65, List.of(fever, cough)));
        persons.add(new Person("2", "Jane", "Smith", 45, List.of(cough)));
        persons.add(new Person("3", "Alice", "Johnson", 72, List.of(breathlessness)));
    }

    public Symptom findSymptomByName(String name) {
        return symptoms.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

}

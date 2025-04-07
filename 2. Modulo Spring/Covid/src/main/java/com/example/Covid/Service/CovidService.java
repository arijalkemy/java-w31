package com.example.Covid.Service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Covid.Entities.Person;
import com.example.Covid.Entities.RiskPersonDTO;
import com.example.Covid.Entities.Symptom;

@Service
public class CovidService {
    private List<Symptom> symptoms;
    private List<Person> persons;
    private HashMap<Integer, List<Symptom>> personsSymptoms;

    public CovidService() {
        this.symptoms = List.of(
            new Symptom("Fiebre", "Alto"),
            new Symptom("Tos", "Medio"),
            new Symptom("Fatiga", "Bajo"),
            new Symptom("Falta de aire", "Alto"),
            new Symptom("Pérdida de gusto", "Medio")
            );
        this.persons = List.of(
            new Person("John", "Doe", 65),
            new Person("Jane", "Smith", 55),
            new Person("Alice", "Johnson", 70),
            new Person("Bob", "Brown", 45)
        );

        this.personsSymptoms = new HashMap<>();
        personsSymptoms.put(persons.get(0).getId(), List.of(symptoms.get(0), symptoms.get(1)));
        personsSymptoms.put(persons.get(1).getId(), List.of(symptoms.get(2)));
        personsSymptoms.put(persons.get(2).getId(), List.of(symptoms.get(3), symptoms.get(4)));
        personsSymptoms.put(persons.get(3).getId(), List.of(symptoms.get(1)));
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }
    public List<Person> getPersons() {
        return persons;
    }

    public Symptom getSymptomByName(String name) {
        return symptoms.stream()
                        .filter(s -> s.getName().equalsIgnoreCase(name))
                        .findFirst()
                        .orElse(null);
    }

    public List<RiskPersonDTO> getRiskPersons() {
        return persons.stream()
                .filter(p -> p.getAge() > 60 && personsSymptoms.get(p.getId()).size() > 0)
                .map(p -> new RiskPersonDTO(p.getName(), p.getLastName(), personsSymptoms.get(p.getId())))
                .toList();
    }
}

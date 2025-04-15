package com.bootcamp.ejercicio_covid19.service;

import com.bootcamp.ejercicio_covid19.dto.PersonDto;
import com.bootcamp.ejercicio_covid19.model.Person;
import com.bootcamp.ejercicio_covid19.model.Symptom;
import com.bootcamp.ejercicio_covid19.repository.IPersonRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {
    private final IPersonRepository personRepository;

    @Autowired
    public PersonService(IPersonRepository personRepository) {
        this.personRepository = personRepository;
        loadData();
    }

    private void loadData() {
        personRepository.saveAll(List.of(
                new Person(1, "Juan", "Pérez", 30, List.of(
                        new Symptom("SYM1", "Fiebre", "Moderado"),
                        new Symptom("SYM5", "Dolor de cabeza", "Leve")
                )),
                new Person(2, "Ana", "Gómez", 25, List.of(
                        new Symptom("SYM2", "Tos seca", "Leve"),
                        new Symptom("SYM7", "Pérdida del gusto", "Moderado"),
                        new Symptom("SYM12", "Náuseas", "Moderado")
                )),
                new Person(3, "Pedro", "López", 40, List.of(
                        new Symptom("SYM4", "Fatiga", "Moderado"),
                        new Symptom("SYM9", "Dolor muscular", "Moderado"),
                        new Symptom("SYM19", "Insomnio", "Leve")
                )),
                new Person(4, "Lucía", "Martínez", 28, List.of(
                        new Symptom("SYM3", "Dificultad para respirar", "Alto"),
                        new Symptom("SYM10", "Escalofríos", "Leve")
                )),
                new Person(5, "Carlos", "Ramírez", 35, List.of(
                        new Symptom("SYM8", "Pérdida del olfato", "Moderado"),
                        new Symptom("SYM16", "Dolor abdominal", "Moderado"),
                        new Symptom("SYM20", "Sibilancias", "Alto")
                )),
                new Person(6, "María", "Hernández", 32, List.of(
                        new Symptom("SYM6", "Dolor de garganta", "Leve"),
                        new Symptom("SYM14", "Diarrea", "Moderado")
                ))
        ));
    }

    @Override
    public List<PersonDto> getRiskPersons() {
        return new ObjectMapper().convertValue(personRepository.getRiskPerson(), new TypeReference<List<PersonDto>>() {});
    }
}

package com.mercadolibre.ejerciciocovid.service;

import com.mercadolibre.ejerciciocovid.entity.Person;
import com.mercadolibre.ejerciciocovid.entity.PersonDTO;
import com.mercadolibre.ejerciciocovid.entity.Symptom;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class CovidService {

    private List<Symptom> symptoms = new ArrayList<>();
    private List<Person> people = new ArrayList<>();
    public CovidService(){
        symptoms.add(new Symptom(2341, "Fiebre", 3));
        symptoms.add(new Symptom(1234, "Dolor muscular", 1));
        symptoms.add(new Symptom(1827, "Vomitos", 2));
        symptoms.add(new Symptom(9384, "Tos", 3));

        people.add(new Person(1, "Ornella", "Alonso", 22));
        people.add(new Person(2, "Emilio", "Pucci", 72)) ;
        people.add(new Person(3, "Mirtha", "Del Carmen", 69));
        people.add(new Person(4, "Noelia", "Pucci", 46));
        people.add(new Person(5, "Susana", "Zannoni", 80));
    }

    public List<Symptom> getSymptoms(){
        return this.symptoms;
    }

    public String getGravityOfSymptomByName(String name){
        Symptom symptom = this.symptoms.stream().filter(s -> s.getName().equals(name))
                                                .findFirst().orElse(null);
        return "El nivel de gravedad del sintoma " + symptom.getName() + " es: " + symptom.getLevelOfGravity();

    }


    public List<PersonDTO> getRiskPerson() {
        AtomicInteger index = new AtomicInteger(0);
        return this.people.stream()
                .filter(p -> p.getAge() >= 60)
                .map(p -> {
                    int i = index.getAndIncrement();
                    Symptom symptom = this.symptoms.get(i % this.symptoms.size());
                    return new PersonDTO(p.getName(), p.getLastname(), symptom);
                })
                .collect(Collectors.toList());
    }
}

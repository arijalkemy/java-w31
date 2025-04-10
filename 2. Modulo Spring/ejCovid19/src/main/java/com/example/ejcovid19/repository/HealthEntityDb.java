package com.example.ejcovid19.repository;

import com.example.ejcovid19.service.Person;
import com.example.ejcovid19.service.Symptom;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class HealthEntityDb {
    @Getter
    List<Symptom> symptoms = new ArrayList<>();
    @Getter
    List<Person> pacients = new ArrayList<>();


    public HealthEntityDb() {
        symptoms.add(new Symptom("01", "VIH", 2));
        symptoms.add(new Symptom("02", "Covid-19", 4));
        symptoms.add(new Symptom("03", "Hepatitis-B", 3));

        pacients.add(new Person(1, "Martin", "Hernandez", 30));
        pacients.add(new Person(2, "Carlos", "Perez", 67));
        pacients.add(new Person(3, "Julio", "Sanchez", 68));
        pacients.add(new Person(4, "Joe", "Doe", 72));


    }

    public String levelOfSymptom(String name){
        for(Symptom symptom : symptoms){
            if(symptom.getName().equals(name)){
                return "Level of symptom is: " + symptom.getLevel();
            }
        }
        return "Not found";
    }

}

package co.com.mercadolibre.diecinueve.coviddiecinueve.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import co.com.mercadolibre.diecinueve.coviddiecinueve.domain.Person;
import co.com.mercadolibre.diecinueve.coviddiecinueve.domain.Symptom;
import co.com.mercadolibre.diecinueve.coviddiecinueve.dto.PersonDto;
import co.com.mercadolibre.diecinueve.coviddiecinueve.dto.SymptomDto;
import co.com.mercadolibre.diecinueve.coviddiecinueve.enums.Severity;

@Service
public class PersonServiceImpl implements PersonService{

    List<Person> personList = new ArrayList<>();

    @Override
    public List<PersonDto> findCommonSymptomsOnPersonOverSixtyYears() {

        Person firstPerson = new Person(2L, "Jhon", "Doe", 60, 
        new Symptom("212121", "Sore throat", Severity.CRITICAL));

        Person secondPerson = new Person(3L, "Jane", "Doe", 61, 
        new Symptom("313131", "Sore throat", Severity.MODERATE));


        Person thirdPerson = new Person(4L, "Marcus", "Doe",32, 
        new Symptom("414141", "Sore throat", Severity.SEVERE));

        Person fourthPerson = new Person(5L, "Scott", "Doe", 33, 
        new Symptom("515151", "Sore throat", Severity.MILD));

        Person fifthPerson = new Person(6L, "Nate", "Doe", 34, 
        new Symptom("616161", "Sore throat", Severity.MILD));
        
        personList.add(firstPerson);
        personList.add(secondPerson);
        personList.add(thirdPerson);
        personList.add(fourthPerson);
        personList.add(fifthPerson);

        return personList
        .stream()
        .filter(p -> p.getAge() >= 60 && p.equals(p.getSymptom().getName()))
        .map(p -> new PersonDto(null, p.getName(), p.getLastName(), 0, 
        new SymptomDto(p.getSymptom().getCode(), p.getSymptom().getName(), p.getSymptom().getSeverity())))
        .toList();
    }

    
}

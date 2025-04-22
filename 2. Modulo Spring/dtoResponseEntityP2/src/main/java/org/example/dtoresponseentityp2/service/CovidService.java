package org.example.dtoresponseentityp2.service;

import org.example.dtoresponseentityp2.interfaces.CovidInterface;
import org.example.dtoresponseentityp2.model.entity.BdInMemory;
import org.example.dtoresponseentityp2.model.entity.Person;
import org.example.dtoresponseentityp2.model.entity.Symptom;
import org.example.dtoresponseentityp2.utilities.NIVEL_DE_GRAVEDAD;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CovidService implements CovidInterface {


    public BdInMemory cargarDatos(){
        Person person1 = new Person(1,"juan","oñate",20);
        Person person2 = new Person(2,"luisa","castañeda",70);
        Person person3 = new Person(3,"carlos","zamabrano",80);

        Symptom symptom1 = new Symptom("1","Resfriado", NIVEL_DE_GRAVEDAD.BAJO);
        Symptom symptom2 = new Symptom("2","Dolor de pecho", NIVEL_DE_GRAVEDAD.ALTO);
        Symptom symptom3 = new Symptom("3","No puede respirar", NIVEL_DE_GRAVEDAD.ALTO);

        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);

        List<Symptom> symptomList = new ArrayList<>();
        symptomList.add(symptom1);
        symptomList.add(symptom2);
        symptomList.add(symptom3);

        return new BdInMemory(personList,symptomList);
    };

    @Override
    public  getSymptom(BdInMemory bdInMemory){
        return bdInMemory.getSymptom();
    };

    @Override
    public void findRiskPerson(){

    };

    @Override
    public void getSymptomByName(String name){

    };

}

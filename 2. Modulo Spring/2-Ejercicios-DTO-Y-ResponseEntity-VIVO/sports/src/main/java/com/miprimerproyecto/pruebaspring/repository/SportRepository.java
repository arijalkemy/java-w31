package com.miprimerproyecto.pruebaspring.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.miprimerproyecto.pruebaspring.entity.Person;
import com.miprimerproyecto.pruebaspring.entity.Sport;

@Repository
public class SportRepository {

    private List<Sport> listSport;
    private HashMap<Sport, List<Person>> sportPersonlink;

    public SportRepository(List<Sport> listSport, HashMap<Sport, List<Person>> sportPersonlink){
        this.listSport = listSport;
        this.sportPersonlink = sportPersonlink;
        this.loadDate();
    }

    public List<Sport> getSports(){
        return this.listSport;
    }

    public void loadDate(){
        Sport sport1 = new Sport("futbol", "high");
        Sport sport2 = new Sport("basketball", "medium");
        Sport sport3 = new Sport("golf", "medium");

        listSport.add(sport1);
        listSport.add(sport2);
        listSport.add(sport3);

        Person person1 = new Person("Pepe", "Argento", 24);
        Person person2 = new Person("Lucía", "González", 30);
        Person person3 = new Person("Carlos", "Pérez", 28);
        Person person4 = new Person("María", "López", 35);
        Person person5 = new Person("Juan", "Martínez", 40);
        Person person6 = new Person("Ana", "Fernández", 22);

        List<Person> listsport1 = new ArrayList<>();
        listsport1.add(person1);
        listsport1.add(person2);
        listsport1.add(person3);

        List<Person> listsport2 = new ArrayList<>();
        listsport2.add(person4);
        listsport2.add(person5);

        List<Person> listsport3 = new ArrayList<>();
        listsport3.add(person6);

        this.sportPersonlink.put(sport1, listsport1);
        this.sportPersonlink.put(sport1, listsport1);
        this.sportPersonlink.put(sport3, listsport3);
    }

    public Boolean sportInList(String name){
        for (Sport sport : this.listSport){
            if (sport.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public HashMap<Sport, List<Person>> getPerson(){
        return sportPersonlink;
    }
    
}

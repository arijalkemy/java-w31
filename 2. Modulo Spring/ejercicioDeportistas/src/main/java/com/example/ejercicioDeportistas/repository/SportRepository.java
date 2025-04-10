package com.example.ejercicioDeportistas.repository;

import com.example.ejercicioDeportistas.model.Person;
import com.example.ejercicioDeportistas.model.Sport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SportRepository {
    List<Sport> sports;
    HashMap<String,List<Person>> sportPersons;

    public SportRepository() {
        sports = new ArrayList<Sport>() {{
            add(new Sport("Futbol", 11));
            add(new Sport("Baloncesto", 5));
            add(new Sport("Tenis", 1));
        }};

        sportPersons = new HashMap<>();
        List<Person> futbolPlayers = new ArrayList<Person>() {{
            add(new Person("Martin", "Perez", 23));
            add(new Person("Pablo", "Perez", 27));
            add(new Person("Juan", "Perez", 32));
        }};
        List<Person> tenisPlayers = new ArrayList<Person>() {{
            add(new Person("Pedro", "Sanchez", 43));
            add(new Person("Leo", "Perez", 37));
            add(new Person("Gustavo", "Lopez", 22));
        }};
        sportPersons.put("Futbol", futbolPlayers);
        sportPersons.put("Tenis", tenisPlayers);

    }
    public List<Sport> getSports() {
        return sports;
    }
    public HashMap<String, List<Person>> getSportPersons() {
        return sportPersons;
    }
}

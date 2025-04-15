package com.bootcamp.ejercicio_deportistas.repository;

import com.bootcamp.ejercicio_deportistas.model.Person;
import com.bootcamp.ejercicio_deportistas.model.Sport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SportRepository implements ISportRepository{
    private List<Sport> sports = new ArrayList<>();
    private List<Person> persons = new ArrayList<>();

    public SportRepository(){
        sports.add(new Sport("Fútbol", 5));
        sports.add(new Sport("Baloncesto", 4));
        sports.add(new Sport("Tenis", 3));
        sports.add(new Sport("Natación", 5));
        sports.add(new Sport("Ciclismo", 4));
        sports.add(new Sport("Atletismo", 3));
        sports.add(new Sport("Golf", 2));
        sports.add(new Sport("Boxeo", 4));
        sports.add(new Sport("Rugby", 5));
        sports.add(new Sport("Voleibol", 3));

        persons.add(new Person("Lionel", "Messi", 34, List.of(sports.get(0))));
        persons.add(new Person("Cristiano", "Ronaldo", 36, List.of(sports.get(0))));

        persons.add(new Person("LeBron", "James", 36, List.of(sports.get(1))));
        persons.add(new Person("Kevin", "Durant", 32, List.of(sports.get(1))));

        persons.add(new Person("Roger", "Federer", 40, List.of(sports.get(2))));
        persons.add(new Person("Serena", "Williams", 39, List.of(sports.get(2))));

        persons.add(new Person("Michael", "Phelps", 35, List.of(sports.get(3))));
        persons.add(new Person("Katie", "Ledecky", 24, List.of(sports.get(3))));

        persons.add(new Person("Lance", "Armstrong", 50, List.of(sports.get(4))));
        persons.add(new Person("Chris", "Froome", 36, List.of(sports.get(4))));

        persons.add(new Person("Usain", "Bolt", 35, List.of(sports.get(5))));
        persons.add(new Person("Carl", "Lewis", 60, List.of(sports.get(5))));

        persons.add(new Person("Tiger", "Woods", 45, List.of(sports.get(6))));
        persons.add(new Person("Phil", "Mickelson", 50, List.of(sports.get(6))));

        persons.add(new Person("Muhammad", "Ali", 74, List.of(sports.get(7))));
        persons.add(new Person("Mike", "Tyson", 55, List.of(sports.get(7))));

        persons.add(new Person("Richie", "McCaw", 41, List.of(sports.get(8))));
        persons.add(new Person("Jonny", "Wilkinson", 43, List.of(sports.get(8))));

        persons.add(new Person("Kerri", "Walsh", 44, List.of(sports.get(9))));
        persons.add(new Person("Misty", "May", 43, List.of(sports.get(9))));
    }

    @Override
    public List<Sport> getAll() {
        return sports;
    }

    @Override
    public Sport getByName(String name) {
        return sports.stream().filter(sport -> sport.getName().equalsIgnoreCase(name)).findFirst().orElse(new Sport());
    }

    @Override
    public List<Person> getSportPersons() {
        return persons;
    }
}

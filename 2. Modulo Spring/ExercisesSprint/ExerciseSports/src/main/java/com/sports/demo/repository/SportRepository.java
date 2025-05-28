package com.sports.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.sports.demo.entity.Person;
import com.sports.demo.entity.Sport;

@Repository
public class SportRepository implements ISportRepository {

    List<Sport> listSports = new ArrayList<>();
    List<Person> listPerson = new ArrayList<>();

    public SportRepository() {
        listSports = List.of(
                new Sport("Rugby", 3),
                new Sport("Futbol Americano", 2),
                new Sport("Baloncesto ", 4),
                new Sport("Balon mano", 1),
                new Sport("Natación", 5),
                new Sport("Boxeo", 1),
                new Sport("Patinaje", 2),
                new Sport("Tenis", 3),
                new Sport("Hockey", 4),
                new Sport("Beisbol", 3));

        listPerson = List.of(
                new Person("Martha", "Ramirez", 23, List.of(listSports.get(0), listSports.get(5))),
                new Person("Diego", "Restrepo", 26, List.of(listSports.get(7), listSports.get(4))),
                new Person("Juliana", "Pulido", 15, List.of()),
                new Person("Lady", "Cañon", 29, List.of()),
                new Person("Harrison", "Cañon", 32, List.of(listSports.get(2)))

        );

    }

    @Override
    public List<Sport> getSports() {
        return listSports;
    }

    @Override
    public Optional<Sport> getByName(String name) {
        return listSports.stream().filter(s -> s.getNameSport().toLowerCase().equals(name.toLowerCase())).findFirst();
    }

    @Override
    public List<Person> getSportsPersons() {
     return  listPerson.stream().filter(p-> !p.getSports().isEmpty()).toList();
    }

}

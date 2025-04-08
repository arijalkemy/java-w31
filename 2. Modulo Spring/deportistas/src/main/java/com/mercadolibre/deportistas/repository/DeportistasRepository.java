package com.mercadolibre.deportistas.repository;

import com.mercadolibre.deportistas.model.Sport;
import com.mercadolibre.deportistas.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DeportistasRepository {
    List<Person> people;
    List<Sport> sports;

    public DeportistasRepository() {
        this.people = new ArrayList<>();
        this.sports = new ArrayList<>();

        agregarDeporte(new Sport("Tenis", "Principiante"));
        agregarDeporte(new Sport("Tenis", "Avanzado"));
        agregarDeporte(new Sport("Fútbol", "Intermedio"));
        agregarDeporte(new Sport("Natación", "Avanzado"));

        agregarPersona(new Person("Pepe", "Rodriguez", 25));
        agregarPersona(new Person("Maria", "Martinez", 30));
        agregarPersona(new Person("Jose", "Perez", 35));

        people.get(0).agregarDeporte(sports.get(0));
        people.get(1).agregarDeporte(sports.get(1));
        people.get(2).agregarDeporte(sports.get(2));
        people.get(2).agregarDeporte(sports.get(3));
    }

    public void agregarPersona(Person person) {
        this.people.add(person);
    }

    public void agregarDeporte(Sport sport) {
        this.sports.add(sport);
    }

    public List<Person> getPersonas() {
        return people;
    }

    public List<Sport> getDeportes() {
        return sports;
    }

    public String buscar(String nombre) {
        Optional<Sport> deporteEncontrado = sports.stream().filter(sport -> sport.getNombre()
                .equalsIgnoreCase(nombre)).findFirst();

        if (deporteEncontrado.isPresent()) {
            return "Deporte encontrado: " + deporteEncontrado.get().getNombre();
        }
        return "No se encontró el deporte";
    }
}

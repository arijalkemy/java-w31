package com.mercadolibre.deportista.repository;


import com.mercadolibre.deportista.model.Person;
import com.mercadolibre.deportista.model.Sport;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
public class DataRepository {
    private final List<Sport> sports = new ArrayList<>();
    private final List<Person> persons = new ArrayList<>();

    public DataRepository() {
        Sport soccer = new Sport("soccer", "advanced");
        Sport swimming = new Sport("swimming", "intermediate");
        Sport skating = new Sport("skating", "advanced");
        Sport tennis = new Sport("tennis", "novice");
        Sport basketball = new Sport("basketball", "novice");

        sports.add(soccer);
        sports.add(swimming);
        sports.add(skating);
        sports.add(tennis);
        sports.add(basketball);

        persons.add(new Person("David", "Varon", 25, skating));
        persons.add(new Person("Alejandro", "Castro", 24, tennis));
        persons.add(new Person("Michelle", "Zabala", 20, soccer));
        persons.add(new Person("Andres", "Lopez", 21, swimming));
        persons.add(new Person("Miranda", "Arteaga", 23, basketball));
    }

    public Sport findSportByName(String name) {
        return sports.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}

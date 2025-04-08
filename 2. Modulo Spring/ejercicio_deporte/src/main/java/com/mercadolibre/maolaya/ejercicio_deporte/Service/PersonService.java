package com.mercadolibre.maolaya.ejercicio_deporte.Service;

import java.util.ArrayList;
import java.util.List;

import com.mercadolibre.maolaya.ejercicio_deporte.Model.Person;
import com.mercadolibre.maolaya.ejercicio_deporte.Model.Sport;
import com.mercadolibre.maolaya.ejercicio_deporte.Model.Dto.SportPersonDto;

public class PersonService {
    private static List<Person> persons = new ArrayList<>();

    static {
        persons.add(new Person("Juan", "Pérez", "25", new Sport("Football", "Advanced")));
        persons.add(new Person("María", "Gómez", "30", new Sport("Basketball", "Medium")));
        persons.add(new Person("Pedro", "López", "22", new Sport("Baseball", "Medium")));
        persons.add(new Person("Ana", "Martínez", "28", new Sport("Athletics", "Basic")));
    }

    public static List<SportPersonDto> getAllPersons() {
        List<SportPersonDto> sportPersonDtos = new ArrayList<>();
        for (Person person : persons) {
            sportPersonDtos
                    .add(new SportPersonDto(person.getName(), person.getLastname(), person.getSport().getName()));
        }
        return sportPersonDtos;
    }
}

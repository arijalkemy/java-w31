package com.mercadolibre.bootcamp.deportistas.util;

import com.mercadolibre.bootcamp.deportistas.model.Person;
import com.mercadolibre.bootcamp.deportistas.model.Sport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataUtil {
    public static List<Sport> getAllSports() {
        Sport soccer = new Sport("Soccer", "Intermediate");
        Sport basketball = new Sport("Basketball", "Beginner");
        Sport tennis = new Sport("Tennis", "Advanced");

        return Arrays.asList(soccer, basketball, tennis);
    }


    public static List<Person> getAllPersons() {
        List<Sport> sports = getAllSports();

        Person person1 = new Person("John", "Doe", "30", Arrays.asList(sports.get(0), sports.get(2)));
        Person person2 = new Person("Jane", "Smith", "25", Arrays.asList(sports.get(1), sports.get(2)));
        Person person3 = new Person("Alice", "Brown", "20", new ArrayList<>());

        return Arrays.asList(person1, person2, person3);
    }
}

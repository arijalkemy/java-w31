package com.mercadolibre.ejerciciodto.service;

import com.mercadolibre.ejerciciodto.entidades.Person;
import com.mercadolibre.ejerciciodto.entidades.Sport;
import com.mercadolibre.ejerciciodto.entidades.PersonDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FindSportService {
    /* Ver todos los deportes que tenemos cargados.*/
    private List<Sport> sports = new ArrayList<>();
    private List<PersonDTO> sportyPeople = new ArrayList<>();

    public FindSportService() {
        sports.add(new Sport("Fútbol", 3));
        sports.add(new Sport("Básquet", 2));
        sports.add(new Sport("Tenis", 4));

        Person p = new Person("Ornella", "Alonso", 22);
        Person p2 = new Person("Micaela", "Francese", 21);
        Person p3 = new Person("Marianela", "Alonso", 22);
        Person p4 = new Person("Sharon", "Breyani", 24);


        sportyPeople.add(new PersonDTO(p.getName(), p.getLastName(), sports.get(0)));
        sportyPeople.add(new PersonDTO(p2.getName(), p2.getLastName(), sports.get(2)));
        sportyPeople.add(new PersonDTO(p3.getName(), p3.getLastName(), sports.get(1)));
        sportyPeople.add(new PersonDTO(p4.getName(), p4.getLastName(), sports.get(0)));
    }


    public List<Sport> getSports(){
        return this.sports;
    }

    /*Consultar si existe un deporte ingresando su name.
    De existir, se deberá mostrar el nivel del mismo.
    Utilizar la clase ResponseEntity para devolver la respuesta.*/
    public String getSportLevel(String name){
        Sport sport = this.sports.stream().filter(d -> d.getName().equals(name))
                            .findFirst().orElse(null);
        return "El nivel del deporte " + name + " es: " + sport.getLevel();
    }


    /* Visualizar a las personas deportistas. Queremos que se vea un
     listado con el nombre y el apellido de la persona y el nombre del
     deporte que realiza (no es necesario que se vea la edad ni el nivel del deporte realizado).
     Para este punto es importante valerse de un DTO.
       PATH: /findSportsPersons*/
    public List<String> getSportyPeople(){
        return this.sportyPeople.stream()
                .map(pd -> "- " + pd.getName() + " " + pd.getLastName() + " realiza el deporte: " + pd.getSport().getName())
                .collect(Collectors.toList());
    }

    public void save(Sport sport) {
       this.sports.add(sport);
    }
}

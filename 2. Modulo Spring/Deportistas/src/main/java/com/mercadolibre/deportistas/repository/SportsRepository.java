package com.mercadolibre.deportistas.repository;

import com.mercadolibre.deportistas.model.Sport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SportsRepository {
    private List<Sport> sports = new ArrayList<>();

    public SportsRepository() {
        sports.add(new Sport("Futbol", 1));
        sports.add(new Sport("Tennis", 2));
        sports.add(new Sport("Natación", 3));
    }

    public List<Sport> getAllSports() {
        return new ArrayList<>(sports);
    }

    public Sport getSportById(String name) {
       return sports.stream().filter(sport -> sport.getName().equals(name)).findFirst().orElse(null);
    }

}

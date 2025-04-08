package com.bootcamp.ejerciciodeportistas.repository;

import com.bootcamp.ejerciciodeportistas.entity.Sport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SportRepository implements ISportRepository{
    List<Sport> sports;

    public SportRepository(){
        sports = new ArrayList<>();
        sports.add(new Sport("Futbol", "High"));
        sports.add(new Sport("Rugby", "High"));
        sports.add(new Sport("Tenis", "Low"));
        sports.add(new Sport("Golf", "Very high"));
    }
    @Override
    public List<Sport> allSports() {
        return sports;
    }

    @Override
    public Optional<Sport> findSport(String name) {
        return sports.stream().filter(p -> p.getNombre().equals(name)).findFirst();
    }
}

package com.spring.ejerciciodeportistas.repository;

import com.spring.ejerciciodeportistas.model.Sport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SportRepository {
    private static List<Sport> sports = new ArrayList<>();

    static {
        sports.add(new Sport("Volleyball", "High"));
        sports.add(new Sport("Basketball", "Medium"));
        sports.add(new Sport("Soccer", "Low"));
    }

    public List<Sport> findAll() {
        return sports;
    }

    public Sport findByName(String name) {
        for (Sport sport : sports) {
            if (sport.getName().equals(name)) {
                return sport;
            }
        }
        return null;
    }
}

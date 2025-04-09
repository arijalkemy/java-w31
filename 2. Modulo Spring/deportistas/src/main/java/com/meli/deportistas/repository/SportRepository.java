package com.meli.deportistas.repository;

import com.meli.deportistas.model.SportModel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class SportRepository {
    private List<SportModel> sports = new ArrayList<>();

    public SportRepository() {
        sports.add(new SportModel(1, "Soccer", 1));
        sports.add(
                new SportModel(2, "Basketball", 2));
        sports.add(new SportModel(3, "Tenis", 3));
    }

    public List<SportModel> getAllSports() {
        return new ArrayList<>(sports);
    }

    public SportModel getSportById(int id) {
        return sports.stream()
                .filter(sport -> sport.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public SportModel getSportByName(String name) {
        return sports.stream()
                .filter(sport -> sport.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}

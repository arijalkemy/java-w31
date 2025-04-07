package com.bootcamp.sports.services;

import com.bootcamp.sports.models.Sport;

import java.util.ArrayList;
import java.util.List;

public class SportsService {
    private static List<Sport> sports = new ArrayList<>();

    public static List<Sport> getSports() {
        return sports;
    }

    public static Sport getSportByName(String name) {
        return sports.stream().
                filter(sport -> sport.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public static void addSport(Sport sport) {
        if (sport != null) {
            sports.add(sport);
        }
    }
}

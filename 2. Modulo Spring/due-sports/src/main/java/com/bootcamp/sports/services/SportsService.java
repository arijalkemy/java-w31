package com.bootcamp.sports.services;

import com.bootcamp.sports.dtos.SportDto;
import com.bootcamp.sports.models.Sport;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SportsService {
    private static List<Sport> sports = new ArrayList<>();

    public static List<SportDto> getSports() {
        return sports.stream().map(SportDto::buildFromSport).collect(Collectors.toList());
    }

    public static SportDto getSportByName(String name) {
        Optional<Sport> first = sports.stream().
                filter(sport -> sport.getName().equals(name))
                .findFirst();
        SportDto sportDto = null;
        return first.map(SportDto::buildFromSport).orElse(sportDto);
    }

    public static SportDto addSport(SportDto sportDto) {
        if (sportDto != null) {
            Sport sport = Sport.buildFromDto(sportDto);
            sports.add(sport);
            return SportDto.buildFromSport(sport);
        }
        return null;
    }
}

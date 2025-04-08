package com.mercadolibre.maolaya.ejercicio_deporte.Service;

import java.util.ArrayList;
import java.util.List;

import com.mercadolibre.maolaya.ejercicio_deporte.Model.Sport;
import com.mercadolibre.maolaya.ejercicio_deporte.Model.Dto.SportDto;

public class SportService {
    private static List<Sport> sports = new ArrayList<>();

    static {
        sports.add(new Sport("Football", "Advanced"));
        sports.add(new Sport("Basketball", "Medium"));
        sports.add(new Sport("Baseball", "Medium"));
        sports.add(new Sport("Athletics", "Basic"));
        sports.add(new Sport("Tennis", "Advanced"));
        sports.add(new Sport("Swimming", "Basic"));
    }

    public static List<SportDto> getAllSports() {
        List<SportDto> sportDtos = new ArrayList<>();
        for (Sport sport : sports) {
            sportDtos.add(new SportDto(sport.getName(), sport.getLevel()));
        }
        return sportDtos;
    }

    public static String getSport(String name) throws RuntimeException {
        return sports.stream().filter(sport -> sport.getName().equals(name)).map(sport -> sport.getLevel())
                .findFirst().get();
    }
}

package com.mercadolibre.bootcamp.deportistas.service;

import com.mercadolibre.bootcamp.deportistas.dto.AthleteDto;
import com.mercadolibre.bootcamp.deportistas.model.Person;
import com.mercadolibre.bootcamp.deportistas.model.Sport;
import com.mercadolibre.bootcamp.deportistas.util.DataUtil;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SportService {


    public List<Sport> getSports() {
        return DataUtil.getAllSports();
    }

    public Sport getSportByName(String name) {
        return DataUtil.getAllSports().stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
    }

    public List<AthleteDto> getAthletes() {
        List<AthleteDto> athleteDtos = new ArrayList<>();
        List<Person> persons = DataUtil.getAllPersons();
        for (Person person : persons) {
            AthleteDto athleteDto = new AthleteDto(person.getName(), person.getLastName(), person.getSports().stream()
                    .map(Sport::getName)
                    .collect(Collectors.joining(", ")));
            athleteDtos.add(athleteDto);
        }
        return athleteDtos;
    }

}

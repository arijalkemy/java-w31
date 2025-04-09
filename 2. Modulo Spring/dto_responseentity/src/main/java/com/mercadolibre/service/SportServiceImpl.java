package com.mercadolibre.service;

import com.mercadolibre.mapper.PersonMapper;
import com.mercadolibre.mapper.SportMapper;
import com.mercadolibre.model.Person;
import com.mercadolibre.model.Sport;
import com.mercadolibre.model.PersonDto;
import com.mercadolibre.model.SportDto;
import com.mercadolibre.model.SportsManDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class SportServiceImpl implements ISportService{

    private static List<Sport> sportsList = new ArrayList<>();

    // Base de datos en memoria.
    static {
        sportsList.add(new Sport("futbol", "profesional"));
        sportsList.add(new Sport("baloncesto", "profesional"));
        sportsList.add(new Sport("tenis", "profesional"));
        sportsList.add(new Sport("natacion", "profesional"));
    }

    public List<SportsManDto> getSportsManDtos(){
        List<SportsManDto> sportsManList = new ArrayList<>();

        // Instance of Person.
        Person michell = new Person("Michell", "Arias", 25);
        Person hellen = new Person("Hellen", "Parra", 31);
        Person felipe = new Person("Felipe", "Arias", 20);

        // Using Mappers.
        PersonDto michellDto = PersonMapper.personToPersonDto(michell);
        PersonDto hellenDto = PersonMapper.personToPersonDto(hellen);
        PersonDto felipeDto = PersonMapper.personToPersonDto(felipe);

        // Build a SportsManDto
        SportsManDto michellSport = new SportsManDto(
                michellDto.getName(),
                michellDto.getLastName(),
                "futbol");

        SportsManDto hellenSport = new SportsManDto(
                hellenDto.getName(),
                hellenDto.getLastName(),
                "baloncesto");

        SportsManDto felipeSport = new SportsManDto(
                felipeDto.getName(),
                felipeDto.getLastName(),
                "tenis");

        sportsManList.add(michellSport);
        sportsManList.add(hellenSport);
        sportsManList.add(felipeSport);


        return sportsManList;

    }

    @Override
    public List<SportDto> findAll() {
        return sportsList.stream()
                .map(SportMapper::sportToSportDto)
                .toList();
    }

    @Override
    public SportDto findByName(String name) {
        Optional<SportDto> sportFound =  sportsList.stream()
                .filter(s -> s.getName().equals(name))
                .findFirst()
                .map(s ->new SportDto(s.getLevel()));

        //TODO: add optional validation

        return sportFound.get();
    }


    @Override
    public List<SportsManDto> findSoportsAndPersons() {
        return getSportsManDtos();
    }
}

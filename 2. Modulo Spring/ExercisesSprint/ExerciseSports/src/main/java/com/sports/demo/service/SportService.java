package com.sports.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sports.demo.dto.PersonDto;
import com.sports.demo.dto.SportDto;
import com.sports.demo.entity.Person;
import com.sports.demo.entity.Sport;
import com.sports.demo.repository.ISportRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SportService implements ISportService {
    private final ISportRepository sportRepository;

    @Override
    public List<SportDto> findSports() {
        List<Sport> list = sportRepository.getSports();
        return list.stream().map(s ->
        // new SportDto(s.getNameSport(),s.getLevel())
        SportDto.builder().nameSport(s.getNameSport())
                .level(s.getLevel()).build()).toList();
    }

    @Override
    public SportDto getSportByName(String name) throws Exception {
        Optional<Sport> findSport = sportRepository.getByName(name);
        if (findSport.isEmpty()) {
            throw new Exception("No se encontró el deporte");
        }
        Sport sport = findSport.get();
        return SportDto.builder().level(sport.getLevel()).build();

    }

    @Override
    public List<PersonDto> findSportPerson() {
        List<Person> listSportPersons = sportRepository.getSportsPersons();
        return listSportPersons.stream().map(p -> PersonDto.builder().firstName(p.getFirstName())
                .lastName(p.getLastName())
                .sports(p.getSports().stream().map(s -> SportDto.builder().nameSport(s.getNameSport()).build())
                        .toList())
                .build()).toList();
    }
}

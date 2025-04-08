package com.mercadolibre.deportistas.services;

import com.mercadolibre.deportistas.Dto.PersonDTO;
import com.mercadolibre.deportistas.Dto.SportDTo;
import com.mercadolibre.deportistas.model.Sport;
import com.mercadolibre.deportistas.repository.PersonRepository;
import com.mercadolibre.deportistas.repository.SportsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonSportService {
    private final SportsRepository sportsRepository;
    private final PersonRepository personRepository;

    public List<Sport> getAllSports() {
        return sportsRepository.getAllSports();
    }

    public SportDTo getSportByName(String name) {
        var sport = sportsRepository.getSportById(name);
        if (sport == null)
            throw new IllegalArgumentException("El deporte: " + name + " no existe");
        SportDTo sportDTo = new SportDTo();
        sportDTo.setLevel(sport.getLevel());
        return sportDTo;
    }

    public List<PersonDTO> getPersonSportByName() {
        return personRepository.getPersonsAndSports();
    }

}

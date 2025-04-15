package co.com.mercadolibre.practicadeportistas.practicadeportistas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.com.mercadolibre.practicadeportistas.practicadeportistas.domain.Sport;
import co.com.mercadolibre.practicadeportistas.practicadeportistas.dto.PersonDto;
import co.com.mercadolibre.practicadeportistas.practicadeportistas.dto.SportDto;
import co.com.mercadolibre.practicadeportistas.practicadeportistas.enums.SPORT_LEVEL;
import co.com.mercadolibre.practicadeportistas.practicadeportistas.domain.Person;

@Service
public class PersonServiceImpl implements PersonService{

    
    @Override
    public List<PersonDto> findSportsPersons() {
        /*
         * Entities to create dtos-based
         */
        Sport firstSport = new Sport("Soccer", SPORT_LEVEL.EASY);
        Person firstPerson = new Person("Jhon", "Doe", 25, firstSport);
        Sport secondSport = new Sport("Basketball", SPORT_LEVEL.EASY);
        Person secondPerson = new Person("Billie", "Elish", 30, secondSport);
        Sport thirdSport = new Sport("Fotball", SPORT_LEVEL.EASY);
        Person thirdPerson = new Person("Marnie", "MacCoy", 23, thirdSport);
        Sport fourthSport = new Sport("Running", SPORT_LEVEL.EASY);
        Person fourthPerson = new Person("Albert", "Dwayne", 25, fourthSport);
                
        /*
         * Return the List of dtos already mapped from entities
         */
        List<Person> lPersons = List.of(firstPerson, secondPerson, thirdPerson, fourthPerson);
        return lPersons.stream()
        .map(p -> new PersonDto(
        p.getName(),
        p.getLastName(),
        0,
        new SportDto(
            p.getDeporte().getName(),       
            null
        )
        ))
        .toList();
    }

}

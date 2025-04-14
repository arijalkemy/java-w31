package com.miprimerproyecto.pruebaspring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.miprimerproyecto.pruebaspring.dto.PersonaSportDto;
import com.miprimerproyecto.pruebaspring.dto.SportDto;
import com.miprimerproyecto.pruebaspring.entity.Person;
import com.miprimerproyecto.pruebaspring.entity.Sport;
import com.miprimerproyecto.pruebaspring.repository.SportRepository;

@Service
public class SportService {
    
    SportRepository sportRepository;

    public SportService(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

    public List<SportDto> getSports(){
        List<Sport> listSport = sportRepository.getSports();
        return listSport.stream()
            .map(sport -> new SportDto(sport.getName(), sport.getLevel()))
            .toList();
        
    }

    public Boolean sportInList(String name){
        return sportRepository.sportInList(name);
    }

    public List<PersonaSportDto> getPersons(){
        HashMap< Sport, List<Person>> sportPersonLinked = sportRepository.getPerson();
        List<PersonaSportDto> listPersonDto = new ArrayList<>();
        for (Map.Entry<Sport,List<Person>> entry : sportPersonLinked.entrySet() ){
            for(Person person : entry.getValue()){
                listPersonDto.add(new PersonaSportDto(
                        person.getName(),
                        person.getLastname(),
                        entry.getKey().getName()
                    )
                );
            }
        }
        return listPersonDto;
    }
}
